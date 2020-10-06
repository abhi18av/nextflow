.. _cli-page:

******************
Command line interface
******************

`Nextflow` provides a robust command line interface allowing you to manage the execution of a pipeline. The top-level interface consists of two aspects, ``options`` and ``commands``.

Here's what you'll see at the top-level upon invoking ``nextflow`` CLI.::


    $ nextflow
    Usage: nextflow [options] COMMAND [arg...]



.. _cli-options:
CLI Options
============

An overview of the `Nextflow` top-level options::


    $ nextflow
    Usage: nextflow [options] COMMAND [arg...]

    Options:
    -C
        Use the specified configuration file(s) overriding any defaults
    -D
        Set JVM properties
    -bg
        Execute nextflow in background
    -c, -config
        Add the specified file to configuration set
    -d, -dockerize
        Launch nextflow via Docker (experimental)
    -h
        Print this help
    -log
        Set nextflow log file path
    -q, -quiet
        Do not print information messages
    -syslog
        Send logs to syslog server (eg. localhost:514)
    -v, -version
        Print the program version

    Commands...


.. _cli-commands:
CLI Commands
============


An overview of the `Nextflow` top-level commands::


    $ nextflow
    Usage: nextflow [options] COMMAND [arg...]
    
    Options...

    Commands:
    clean         Clean up project cache and work directories
    clone         Clone a project into a folder
    config        Print a project configuration
    console       Launch Nextflow interactive console
    drop          Delete the local copy of a project
    help          Print the usage help for a command
    info          Print project and system runtime information
    kuberun       Execute a workflow in a Kubernetes cluster (experimental)
    list          List all downloaded projects
    log           Print executions log and runtime info
    pull          Download or update a project
    run           Execute a pipeline project
    self-update   Update nextflow runtime to the latest available version
    view          View project script file(s)

--------------------
clean
--------------------


Description
^^^^^^^^^^^^^^^^^^^^
Clean up project specific *cache* and *work* directories

Usage
^^^^^^^^^^^^^^^^^^^^

The ``clean`` command can be invoked like so::


    $ nextflow clean [options]


Extended description
^^^^^^^^^^^^^^^^^^^^
Upon invocation within a directory, ``Nextflow`` creates a project specific ``.nextflow.log`` file, ``.nextflow`` cache directory as well as a ``work`` directory. The ``clean`` option is designed to facilitate rapid iteration without the clutter introduced by previous executions.



Options
^^^^^^^^^^^^^^^^^^^^

+---------------------------+------------+--------------------------------------------------------------------------------+
| Name, shorthand (if any)  | Default    | Description                                                                    | 
+===========================+============+================================================================================+
| -after                    |     -      | Clean up runs executed *after* the specified one.                              |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -before                   |     -      | Clean up runs executed *before* the specified one.                             |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -but                      |     -      | Clean up all runs *except* the specified one.                                  |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -dry-run, -n              |   false    | Print names of files to be removed without deleting them.                      | 
+---------------------------+------------+--------------------------------------------------------------------------------+
| -force, -f                |   false    | Force clean command.                                                           |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -help, -h                 |   false    | Print the command usage.                                                       |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -keep-logs, -k            |   false    | Removes only temporary files but retains execution log entries and metadata.   |                                           
+---------------------------+------------+--------------------------------------------------------------------------------+
| -quiet, -q                |   false    | Do not print names of files removed.                                           |
+---------------------------+------------+--------------------------------------------------------------------------------+



Examples
^^^^^^^^^^^^^^^^^^^^



--------------------
clone         
--------------------


Description
^^^^^^^^^^^^^^^^^^^^
Clone a project into a folder



Usage
^^^^^^^^^^^^^^^^^^^^

The ``clone`` command can be invoked like so::


    $ nextflow clone [options]



Extended description
^^^^^^^^^^^^^^^^^^^^

The ``clone`` command faciliatates collaboration by allowing the users to download any existing pipeline from the specified ``-hub`` into the current directory and modify it accordingly. For downloading the pipeline into the global cache ``~/.nextflow/assets`` , please refer ``pull`` command.

Options
^^^^^^^^^^^^^^^^^^^^

+---------------------------+------------+--------------------------------------------------------------------------------+
| Name, shorthand (if any)  | Default    | Description                                                                    | 
+===========================+============+================================================================================+
| -help, -h                 |  false     | Print the command usage.                                                       |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -hub                      |  github    | Service hub where the project is hosted. Options: ``gitlab`` or ``bitbucket``  |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -r                        |  master    | Revision to clone - It can be a git ``branch``, ``tag`` or ``revision number`` |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -user                     |            | Private repository user name                                                   |
+---------------------------+------------+--------------------------------------------------------------------------------+




Examples
^^^^^^^^^^^^^^^^^^^^



--------------------
config        
--------------------


Description
^^^^^^^^^^^^^^^^^^^^
Print a project configuration

Usage
^^^^^^^^^^^^^^^^^^^^

The ``config`` command can be invoked like so::


    $ nextflow config [options]


Extended description
^^^^^^^^^^^^^^^^^^^^

The ``config`` command is used for printing the project's configuration and is especially useful while debugging.


Options
^^^^^^^^^^^^^^^^^^^^

+---------------------------+------------+--------------------------------------------------------------------------------+
| Name, shorthand (if any)  | Default    | Description                                                                    | 
+===========================+============+================================================================================+
| -flat                     |  false     | Print config using flat notation.                                              |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -help, -h                 |  false     | Print the command usage.                                                       |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -profile                  |            | Choose a configuration profile.                                                |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -properties               |  false     | Print config using Java properties notation.                                   |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -show-profiles, -a        |  false     | Show all configuration profiles.                                               |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -sort                     |  false     | Sort config attributes.                                                        |
+---------------------------+------------+--------------------------------------------------------------------------------+




Examples
^^^^^^^^^^^^^^^^^^^^



--------------------
console       
--------------------


Description
^^^^^^^^^^^^^^^^^^^^
Launch *Nextflow* interactive console


Usage
^^^^^^^^^^^^^^^^^^^^

The ``console`` command can be invoked like so::


    $ nextflow console [options]



Extended description
^^^^^^^^^^^^^^^^^^^^
The ``console`` command is a wrapper over the Groovy *console* and provides an interactive REPL (Read-Eval-Print-Loop) for quick experimentation.


Options
^^^^^^^^^^^^^^^^^^^^
None available


Examples
^^^^^^^^^^^^^^^^^^^^


--------------------
drop          
--------------------


Description
^^^^^^^^^^^^^^^^^^^^
Delete the local copy of a project


Usage
^^^^^^^^^^^^^^^^^^^^

The ``drop`` command can be invoked like so::


    $ nextflow drop [options]




Extended description
^^^^^^^^^^^^^^^^^^^^

The ``drop`` command is used to remove the piplines which have already been downloaded into the global cache. Please refer the ``list`` command for generating a list of downloaded pipelines.

Options
^^^^^^^^^^^^^^^^^^^^

+---------------------------+------------+--------------------------------------------------------------------------------+
| Name, shorthand (if any)  | Default    | Description                                                                    | 
+===========================+============+================================================================================+
| -f                        |  false     | Delete the repository without taking care of local changes.                    |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -help, -h                 |  false     | Print the command usage.                                                       |
+---------------------------+------------+--------------------------------------------------------------------------------+



Examples
^^^^^^^^^^^^^^^^^^^^



--------------------
help          
--------------------


Description
^^^^^^^^^^^^^^^^^^^^
Print the usage help for a command


Usage
^^^^^^^^^^^^^^^^^^^^

The ``help`` command can be invoked like so::


    $ nextflow help [options]


Extended description
^^^^^^^^^^^^^^^^^^^^
This command is equivalent to simply issuing ``nextflow`` at the command line - it prints out the overview of the CLI interface and enumerates the top-level *options* and *commands*.


Options
^^^^^^^^^^^^^^^^^^^^

+---------------------------+------------+--------------------------------------------------------------------------------+
| Name, shorthand (if any)  | Default    | Description                                                                    | 
+===========================+============+================================================================================+
| -help, -h                 |  false     | Print the command usage.                                                       |
+---------------------------+------------+--------------------------------------------------------------------------------+



Examples
^^^^^^^^^^^^^^^^^^^^


--------------------
info          
--------------------


Description
^^^^^^^^^^^^^^^^^^^^
Print project and system runtime information



Usage
^^^^^^^^^^^^^^^^^^^^

The ``info`` command can be invoked like so::


    $ nextflow info [options]



Extended description
^^^^^^^^^^^^^^^^^^^^

The ``info`` command prints out the nextflow runtime information about the hardware as well as the software versions of the ``Nextflow version and build``, ``Operating System`` and ``Groovy and Java runtime``.

Options
^^^^^^^^^^^^^^^^^^^^

+---------------------------+------------+--------------------------------------------------------------------------------+
| Name, shorthand (if any)  | Default    | Description                                                                    | 
+===========================+============+================================================================================+
| -check-updates, -u        |  false     | Check for remote updates.                                                      |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -d                        |  false     | Show detailed information.                                                     |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -help, -h                 |  false     | Print the command usage.                                                       |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -o                        |  text      | Output format, either ``text``, ``json`` or ``yaml``.                          |
+---------------------------+------------+--------------------------------------------------------------------------------+



Examples
^^^^^^^^^^^^^^^^^^^^


--------------------
kuberun       
--------------------


Description
^^^^^^^^^^^^^^^^^^^^
Execute a workflow in a Kubernetes cluster (experimental)


Usage
^^^^^^^^^^^^^^^^^^^^
The ``kuberun`` command can be invoked like so::


    $ nextflow kuberun [options]


Extended description
^^^^^^^^^^^^^^^^^^^^
The ``kuberun`` command building upon the ``run`` command and offers a deep integration with the ``Kubernetes`` execution environment.

Options
^^^^^^^^^^^^^^^^^^^^

+---------------------------+------------+--------------------------------------------------------------------------------+
| Name, shorthand (if any)  | Default    | Description                                                                    | 
+===========================+============+================================================================================+
| -E                        |  false     | Exports all current system environment.                                        |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -ansi-log                 |            | Enable/disable ANSI console logging.                                           |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -bucket-dir               |            | Remote bucket where intermediate result files are stored.                      |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -cache                    |            | Enable/disable processes caching.                                              |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -dsl2                     | false      | Execute the workflow using DSL2 syntax.                                        |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -dump-channels            |            | Dump channels for debugging purpose.                                           |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -dump-hashes              | false      | Dump task hash keys for debugging purpose.                                     |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -e.                       | {}         | Add the specified variable to execution environment. Syntax: ``-e.key=value``  |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -entry                    |            | Entry workflow name to be executed.                                            |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -h, -help                 | false      | Print the command usage.                                                       |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -hub                      | github     | Service hub where the project is hosted. Options: ``gitlab`` or ``bitbucket``  |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -latest                   | false      | Pull latest changes before run.                                                |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -lib                      |            | Library extension path.                                                        |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -name                     |            | Assign a mnemonic name to the a pipeline run.                                  |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -n, -namespace            |            | Specify the K8s namespace to use.                                              |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -offline                  | false      | Do not check for remote project updates.                                       |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -params-file              |            | Load script parameters from a JSON/YAML file.                                  |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -pod-image                |            | Specify the container image for the Nextflow pod.                              |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -process.                 | {}         | Set process options. Syntax ``-process.key=value``                             |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -profile                  |            | Choose a configuration profile.                                                |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -qs, -queue-size          |            | Max number of processes that can be executed in parallel by each executor.     |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -resume                   |            | Execute the script using the cached results, useful to continue executions that|
|                           |            | was stopped by an error.                                                       |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -r, -revision             |            | Revision of the project to run (either a git branch, tag or commit SHA number) |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -test                     |            | Test a script function with the name specified.                                |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -user                     |            | Private repository user name.                                                  |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -v, -volume-mount         |            | Volume claim mounts eg. ``my-pvc:/mnt/path``                                   |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -with-conda               |            | Use the specified Conda environment package or                                 |
|                           |            | file (must end with ``.yml|.yaml``)                                            |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -with-dag                 |            | Create pipeline DAG file.                                                      |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -with-docker              |            | Enable process execution in a Docker container.                                |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -N, -with-notification    |            | Send a notification email on workflow completion to the specified recipients.  |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -with-podman              |            | Enable process execution in a Podman container.                                |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -with-report              |            | Create processes execution html report.                                        |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -with-singularity         |            | Enable process execution in a Singularity container.                           |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -with-timeline            |            | Create processes execution timeline file.                                      |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -with-tower               |            | Monitor workflow execution with Seqera Tower service.                          |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -with-trace               |            | Create processes execution tracing file.                                       |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -with-weblog              |            | Send workflow status messages via HTTP to target URL.                          |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -without-docker           | false      | Disable process execution with Docker.                                         |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -without-podman           |            | Disable process execution in a Podman container.                               |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -w, -work-dir             |            | Directory where intermediate result files are stored.                          |
+---------------------------+------------+--------------------------------------------------------------------------------+




Examples
^^^^^^^^^^^^^^^^^^^^



--------------------
list          
--------------------


Description
^^^^^^^^^^^^^^^^^^^^
List all downloaded projects


Usage
^^^^^^^^^^^^^^^^^^^^
The ``list`` command can be invoked like so::


    $ nextflow list [options]



Extended description
^^^^^^^^^^^^^^^^^^^^

The ``list`` commands prints a list of the projects which are already downloaded into the global cache ``~/.nextflow/assets``.


Options
^^^^^^^^^^^^^^^^^^^^

+---------------------------+------------+--------------------------------------------------------------------------------+
| Name, shorthand (if any)  | Default    | Description                                                                    | 
+===========================+============+================================================================================+
| -help, -h                 |  false     | Print the command usage.                                                       |
+---------------------------+------------+--------------------------------------------------------------------------------+



Examples
^^^^^^^^^^^^^^^^^^^^



--------------------
log           
--------------------


Description
^^^^^^^^^^^^^^^^^^^^
Print executions log and runtime info


Usage
^^^^^^^^^^^^^^^^^^^^

The ``log`` command can be invoked like so::


    $ nextflow log [options]




Extended description
^^^^^^^^^^^^^^^^^^^^
The ``log`` command is used to query the execution logs i.e. ``.nextflow.log`` files which are generated along with every invocation of nextflow.


Options
^^^^^^^^^^^^^^^^^^^^


+---------------------------+------------+--------------------------------------------------------------------------------+
| Name, shorthand (if any)  | Default    | Description                                                                    | 
+===========================+============+================================================================================+
| -after                    |            | Show log entries for runs executed *after* the specified one.                  |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -before                   |            | Show log entries for runs executed *before* the specified one.                 |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -but                      |            | Show log entries for runs executed *but* the specified one.                    |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -filter, -F               |            | Filter log entires by a custom expression                                      |
|                           |            | e.g. ``process =~ /foo.*/ && status == 'COMPLETED'``                           |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -help, -h                 |  false     | Print the command usage.                                                       |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -list-fields, -l          |  false     | Show all available fields.                                                     |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -quiet                    |  false     | Show only run names.                                                           |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -s                        |            | Character used to separate column values                                       |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -template, -t             |            | Text template used to each record in the log.                                  |
+---------------------------+------------+--------------------------------------------------------------------------------+






Examples
^^^^^^^^^^^^^^^^^^^^



--------------------
pull          
--------------------


Description
^^^^^^^^^^^^^^^^^^^^
Download or update a project


Usage
^^^^^^^^^^^^^^^^^^^^

The ``pull`` command can be invoked like so::


    $ nextflow pull [options]




Extended description
^^^^^^^^^^^^^^^^^^^^

The ``pull`` command faciliatates collaboration by allowing the users to download any existing pipeline from the specified ``-hub`` and execute it using the ``run`` command. For downloading the pipeline into the project directory, please refer the ``clone`` command.


Options
^^^^^^^^^^^^^^^^^^^^


+---------------------------+------------+--------------------------------------------------------------------------------+
| Name, shorthand (if any)  | Default    | Description                                                                    | 
+===========================+============+================================================================================+
| -all                      |  false     | Update all downloaded projects.                                                |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -help, -h                 |  false     | Print the command usage.                                                       |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -hub                      |  github    | Service hub where the project is hosted. Options: ``gitlab`` or ``bitbucket``  |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -r                        |            | Revision to run (either a git ``branch``, ``tag`` or commit ``SHA`` number).   |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -user                     |            | Private repository user name                                                   |
+---------------------------+------------+--------------------------------------------------------------------------------+




Examples
^^^^^^^^^^^^^^^^^^^^



--------------------
run           
--------------------


Description
^^^^^^^^^^^^^^^^^^^^
Execute a pipeline project


Usage
^^^^^^^^^^^^^^^^^^^^
The ``run`` command can be invoked like so::


    $ nextflow run [options]



Extended description
^^^^^^^^^^^^^^^^^^^^


Options
^^^^^^^^^^^^^^^^^^^^


+---------------------------+------------+--------------------------------------------------------------------------------+
| Name, shorthand (if any)  | Default    | Description                                                                    |
+===========================+============+================================================================================+
| -E                        |  false     | Exports all current system environment.                                        |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -ansi-log                 |            | Enable/disable ANSI console logging.                                           |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -bucket-dir               |            | Remote bucket where intermediate result files are stored.                      |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -cache                    |            | Enable/disable processes caching.                                              |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -dsl2                     | false      | Execute the workflow using DSL2 syntax.                                        |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -dump-channels            |            | Dump channels for debugging purpose.                                           |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -dump-hashes              | false      | Dump task hash keys for debugging purpose.                                     |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -e.                       | {}         | Add the specified variable to execution environment. Syntax: ``-e.key=value``  |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -entry                    |            | Entry workflow name to be executed.                                            |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -h, -help                 | false      | Print the command usage.                                                       |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -hub                      | github     | Service hub where the project is hosted. Options: ``gitlab`` or ``bitbucket``  |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -latest                   | false      | Pull latest changes before run.                                                |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -lib                      |            | Library extension path.                                                        |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -name                     |            | Assign a mnemonic name to the a pipeline run.                                  |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -offline                  | false      | Do not check for remote project updates.                                       |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -params-file              |            | Load script parameters from a JSON/YAML file.                                  |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -process.                 | {}         | Set process options. Syntax ``-process.key=value``                             |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -profile                  |            | Choose a configuration profile.                                                |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -qs, -queue-size          |            | Max number of processes that can be executed in parallel by each executor.     |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -resume                   |            | Execute the script using the cached results, useful to continue executions that|
|                           |            | was stopped by an error.                                                       |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -r, -revision             |            | Revision of the project to run                                                 |
|                           |            | (either a git ``branch``, ``tag`` or commit ``SHA`` number).                   |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -test                     |            | Test a script function with the name specified.                                |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -user                     |            | Private repository user name.                                                  |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -with-conda               |            | Use the specified Conda environment package or                                 |
|                           |            | file (must end with ``.yml|.yaml``)                                            |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -with-dag                 |            | Create pipeline DAG file.                                                      |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -with-docker              |            | Enable process execution in a Docker container.                                |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -N, -with-notification    |            | Send a notification email on workflow completion to the specified recipients.  |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -with-podman              |            | Enable process execution in a Podman container.                                |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -with-report              |            | Create processes execution html report.                                        |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -with-singularity         |            | Enable process execution in a Singularity container.                           |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -with-timeline            |            | Create processes execution timeline file.                                      |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -with-tower               |            | Monitor workflow execution with Seqera Tower service.                          |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -with-trace               |            | Create processes execution tracing file.                                       |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -with-weblog              |            | Send workflow status messages via HTTP to target URL.                          |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -without-docker           | false      | Disable process execution with Docker.                                         |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -without-podman           |            | Disable process execution in a Podman container.                               |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -w, -work-dir             |            | Directory where intermediate result files are stored.                          |
+---------------------------+------------+--------------------------------------------------------------------------------+






Examples
^^^^^^^^^^^^^^^^^^^^



--------------------
self-update   
--------------------


Description
^^^^^^^^^^^^^^^^^^^^
Update nextflow runtime to the latest available version


Usage
^^^^^^^^^^^^^^^^^^^^
The ``self-update`` command can be invoked like so::


    $ nextflow self-update

Extended description
^^^^^^^^^^^^^^^^^^^^


Examples
^^^^^^^^^^^^^^^^^^^^



--------------------
view          
--------------------


Description
^^^^^^^^^^^^^^^^^^^^
View project script file(s)


Usage
^^^^^^^^^^^^^^^^^^^^
The ``view`` command can be invoked like so::


    $ nextflow view [options]



Extended description
^^^^^^^^^^^^^^^^^^^^


Options
^^^^^^^^^^^^^^^^^^^^

+---------------------------+------------+--------------------------------------------------------------------------------+
| Name, shorthand (if any)  | Default    | Description                                                                    | 
+===========================+============+================================================================================+
| -help, -h                 |  false     | Print the command usage.                                                       |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -l                        |  false     | List repository content.                                                       |
+---------------------------+------------+--------------------------------------------------------------------------------+
| -q                        |  false     | Hide header line.                                                              |
+---------------------------+------------+--------------------------------------------------------------------------------+

Examples
^^^^^^^^^^^^^^^^^^^^


