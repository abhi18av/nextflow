/*
 * Copyright 2020-2021, Seqera Labs
 * Copyright 2013-2019, Centre for Genomic Regulation (CRG)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nextflow.mamba

import groovy.transform.CompileStatic
import groovy.transform.PackageScope
import groovy.util.logging.Slf4j
import groovyx.gpars.dataflow.DataflowVariable
import groovyx.gpars.dataflow.LazyDataflowVariable
import nextflow.Global

import nextflow.file.FileMutex
import nextflow.util.CacheHelper
import nextflow.util.Duration
import nextflow.util.Escape
import org.yaml.snakeyaml.Yaml

import java.nio.file.FileSystems
import java.nio.file.NoSuchFileException
import java.nio.file.Path
import java.nio.file.Paths
import java.util.concurrent.ConcurrentHashMap

/**
 * Handle Mamba environment creation and caching
 *
 * @author Paolo Di Tommaso <paolo.ditommaso@gmail.com>
 */
@Slf4j
@CompileStatic
class MambaCache {

    /**
     * Cache the prefix path for each Mamba environment
     */
    static final private Map<String, DataflowVariable<Path>> mambaPrefixPaths = new ConcurrentHashMap<>()

    /**
     * The Mamba settings defined in the nextflow config file
     */
    private MambaConfig config

    /**
     * Timeout after which the environment creation is aborted
     */
    private Duration createTimeout = Duration.of('20min')

    private String createOptions

    private Path configCacheDir0

    @PackageScope
    String getCreateOptions() { createOptions }

    @PackageScope
    Duration getCreateTimeout() { createTimeout }

    @PackageScope
    Map<String, String> getEnv() { System.getenv() }

    @PackageScope
    Path getConfigCacheDir0() { configCacheDir0 }

    /** Only for debugging purpose - do not use */
    @PackageScope
    MambaCache() {}

    /**
     * Create a Mamba env cache object
     *
     * @param config A {@link Map} object
     */
    MambaCache(MambaConfig config) {
        this.config = config

        if( config.createTimeout )
            createTimeout = config.createTimeout as Duration

        if( config.createOptions )
            createOptions = config.createOptions

        if( config.cacheDir )
            configCacheDir0 = (config.cacheDir as Path).toAbsolutePath()
    }

    /**
     * Retrieve the directory where store the mamba environment.
     *
     * If tries these setting in the following order:
     * 1) {@code mamba.cacheDir} setting in the nextflow config file;
     * 2) the {@code $workDir/mamba} path
     *
     * @return
     *      the {@code Path} where store the mamba envs
     */
    @PackageScope
    Path getCacheDir() {

        def cacheDir = configCacheDir0

        if( !cacheDir && getEnv().NXF_MAMBA_CACHEDIR )
            cacheDir = getEnv().NXF_MAMBA_CACHEDIR as Path

        if( !cacheDir )
            cacheDir = getSessionWorkDir().resolve('mamba')

        if( cacheDir.fileSystem != FileSystems.default ) {
            throw new IOException("Cannot store Mamba environments to a remote work directory -- Use a POSIX compatible work directory or specify an alternative path with the `mamba.cacheDir` config setting")
        }

        if( !cacheDir.exists() && !cacheDir.mkdirs() ) {
            throw new IOException("Failed to create Mamba cache directory: $cacheDir -- Make sure a file with the same does not exist and you have write permission")
        }

        return cacheDir
    }

    @PackageScope
    Path getSessionWorkDir() {
        Global.session.workDir
    }

    @PackageScope
    boolean isYamlFilePath(String str) {
        (str.endsWith('.yml') || str.endsWith('.yaml')) && !str.contains('\n')
    }

    boolean isTextFilePath(String str) {
        str.endsWith('.txt') && !str.contains('\n')
    }


    /**
     * Get the path on the file system where store a Mamba environment
     *
     * @param mambaEnv The mamba environment
     * @return the mamba unique prefix {@link Path} where the env is created
     */
    @PackageScope
    Path mambaPrefixPath(String mambaEnv) {
        assert mambaEnv

        String content
        String name = 'env'
        // check if it's a YAML file
        if( isYamlFilePath(mambaEnv) ) {
            try {
                final path = mambaEnv as Path
                content = path.text
                final yaml = (Map) new Yaml().load(content)
                if( yaml.name )
                    name = yaml.name
                else
                    name = path.baseName
            }
            catch (NoSuchFileException e) {
                throw new IllegalArgumentException("Mamba environment file does not exist: $mambaEnv")
            }
            catch (Exception e) {
                throw new IllegalArgumentException("Error parsing Mamba environment YAML file: $mambaEnv -- Chech the log file for details", e)
            }
        } else if( isTextFilePath(mambaEnv) ) {
            try {
                final path = mambaEnv as Path
                content = path.text
                name = path.baseName
            }
            catch (NoSuchFileException e) {
                throw new IllegalArgumentException("Mamba environment file does not exist: $mambaEnv")
            }
            catch (Exception e) {
                throw new IllegalArgumentException("Error parsing Mamba environment text file: $mambaEnv -- Chech the log file for details", e)
            }
        }
        // it's interpreted as user provided prefix directory
        else if( mambaEnv.contains('/') ) {
            final prefix = mambaEnv as Path
            if( !prefix.isDirectory() )
                throw new IllegalArgumentException("Mamba prefix path does not exist or it's not a directory: $prefix")
            if( prefix.fileSystem != FileSystems.default )
                throw new IllegalArgumentException("Mamba prefix path must be a POSIX file path: $prefix")

            return prefix
        } else if( mambaEnv.contains('\n') ) {
            throw new IllegalArgumentException("Invalid Mamba environment definition: $mambaEnv")
        } else {
            content = mambaEnv
        }

        final hash = CacheHelper.hasher(content).hash().toString()
        getCacheDir().resolve("$name-$hash")
    }

    /**
     * Run the mamba tool to create an environment in the file system.
     *
     * @param mambaEnv The mamba environment definition
     * @return the mamba environment prefix {@link Path}
     */
    @PackageScope
    Path createLocalMambaEnv(String mambaEnv) {
        final prefixPath = mambaPrefixPath(mambaEnv)
        if( prefixPath.isDirectory() ) {
            log.debug "Mamba found local env for environment=$mambaEnv; path=$prefixPath"
            return prefixPath
        }

        final file = new File("${prefixPath.parent}/.${prefixPath.name}.lock")
        final wait = "Another Nextflow instance is creatign the Mamba environment $mambaEnv -- please wait it completes"
        final err = "Unable to acquire exclusive lock after $createTimeout on file: $file"

        final mutex = new FileMutex(target: file, timeout: createTimeout, waitMessage: wait, errorMessage: err)
        try {
            mutex.lock { createLocalMambaEnv0(mambaEnv, prefixPath) }
        }
        finally {
            file.delete()
        }

        return prefixPath
    }

    @PackageScope
    Path makeAbsolute(String envFile) {
        Paths.get(envFile).toAbsolutePath()
    }

    @PackageScope
    Path createLocalMambaEnv0(String mambaEnv, Path prefixPath) {

        log.info "Creating Mamba env: $mambaEnv [cache $prefixPath]"

        final opts = createOptions ? "$createOptions " : ''
        def cmd
        if( isYamlFilePath(mambaEnv) ) {
            cmd = "mamba env create --prefix ${Escape.path(prefixPath)} --file ${Escape.path(makeAbsolute(mambaEnv))}"
        } else if( isTextFilePath(mambaEnv) ) {
            cmd = "mamba create $opts--mkdir --yes --quiet --prefix ${Escape.path(prefixPath)} --file ${Escape.path(makeAbsolute(mambaEnv))}"
        } else {
            cmd = "mamba create $opts--mkdir --yes --quiet --prefix ${Escape.path(prefixPath)} $mambaEnv"
        }

        try {
            runCommand(cmd)
            log.debug "Mamba create complete env=$mambaEnv path=$prefixPath"
        }
        catch (Exception e) {
            // clean-up to avoid to keep eventually corrupted image file
            prefixPath.delete()
            throw e
        }
        return prefixPath
    }

    @PackageScope
    int runCommand(String cmd) {
        log.trace """Mamba create
                     command: $cmd
                     timeout: $createTimeout""".stripIndent()

        final max = createTimeout.toMillis()
        final builder = new ProcessBuilder(['bash', '-c', cmd])
        final proc = builder.start()
        final err = new StringBuilder()
        final consumer = proc.consumeProcessErrorStream(err)
        proc.waitForOrKill(max)
        def status = proc.exitValue()
        if( status != 0 ) {
            consumer.join()
            def msg = "Failed to create Mamba environment\n  command: $cmd\n  status : $status\n  message:\n"
            msg += err.toString().trim().indent('    ')
            throw new IllegalStateException(msg)
        }
        return status
    }

    /**
     * Given a remote image URL returns a {@link DataflowVariable} which holds
     * the local image path.
     *
     * This method synchronise multiple concurrent requests so that only one
     * image download is actually executed.
     *
     * @param mambaEnv
     *      Mamba environment string
     * @return
     *      The {@link DataflowVariable} which hold (and pull) the local image file
     */
    @PackageScope
    DataflowVariable<Path> getLazyImagePath(String mambaEnv) {
        if( mambaEnv in mambaPrefixPaths ) {
            log.trace "Mamba found local environment `$mambaEnv`"
            return mambaPrefixPaths[mambaEnv]
        }

        synchronized (mambaPrefixPaths) {
            def result = mambaPrefixPaths[mambaEnv]
            if( result == null ) {
                result = new LazyDataflowVariable<Path>({ createLocalMambaEnv(mambaEnv) })
                mambaPrefixPaths[mambaEnv] = result
            } else {
                log.trace "Mamba found local cache for environment `$mambaEnv` (2)"
            }
            return result
        }
    }

    /**
     * Create a mamba environment caching it in the file system.
     *
     * This method synchronise multiple concurrent requests so that only one
     * environment is actually created.
     *
     * @param mambaEnv The mamba environment string
     * @return the local environment path prefix {@link Path}
     */
    Path getCachePathFor(String mambaEnv) {
        def promise = getLazyImagePath(mambaEnv)
        def result = promise.getVal()
        if( promise.isError() )
            throw new IllegalStateException(promise.getError())
        if( !result )
            throw new IllegalStateException("Cannot create Mamba environment `$mambaEnv`")
        log.trace "Mamba cache for env `$mambaEnv` path=$result"
        return result
    }

}
