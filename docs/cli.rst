.. _cli-page:

******************
Nextflow CLI Guide
******************

`Nextflow` provides a robust command line interface allowing you to manage the execution of a pipeline. Here's what you'll see at the top-level::

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

The top-level interface consists of two core aspects, `options` and `commands`. tldr;

.. _cli-toplevel-options:

Top-level CLI Options
============


The top-level CLI options for `Nextflow` look like this::

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



.. _cli-run:

run
============


Description
--------------------

Talk about the `nextflow run` command::

    nextflow run

Extended description
--------------------


Options
--------------------



Examples
--------------------


.. _cli-toplevel-commands:

Top-level CLI Commands
============


The top-level CLI options for `Nextflow` look like this::

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



.. _cli-run:

run
============


Description
--------------------

Talk about the `nextflow run` command::

    nextflow run

Extended description
--------------------


Options
--------------------



Examples
--------------------
