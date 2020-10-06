.. _cli-page:

******************
Command line interface
******************

`Nextflow` provides a robust command line interface allowing you to manage the execution of a pipeline. Here's what you'll see at the top-level. 
The top-level interface consists of two aspects, `options` and `commands`.::


    $ nextflow
    Usage: nextflow [options] COMMAND [arg...]



.. _cli-options:
CLI Options
============

An overview of the `Nextflow` options::


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


An overview of the `Nextflow` commands::


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

clean
--------------------


Description
^^^^^^^^^^^^^^^^^^^^
Clean up project cache and work directories

Extended description
^^^^^^^^^^^^^^^^^^^^


Options
^^^^^^^^^^^^^^^^^^^^

+--------------------------+------------+--------------------------------------------------------------------------------+
| Name, shorthand (if any) | Default    | Description                                                                    | 
+==========================+============+================================================================================+
| after                    |     -      | Clean up runs executed *after* the specified one.                              |
+--------------------------+------------+--------------------------------------------------------------------------------+
| before                   |     -      | Clean up runs executed *before* the specified one.                             |
+--------------------------+------------+--------------------------------------------------------------------------------+
| but                      |     -      | Clean up all runs *except* the specified one.                                  |
+--------------------------+------------+--------------------------------------------------------------------------------+
| dry-run, n               |   false    | Print names of files to be removed without deleting them.                      | 
+--------------------------+------------+--------------------------------------------------------------------------------+
| force, n                 |   false    | Force clean command.                                                           |
+--------------------------+------------+--------------------------------------------------------------------------------+
| help, h                  |   false    | Print the command usage.                                                       |
+--------------------------+------------+--------------------------------------------------------------------------------+
| keep-logs, k             |   false    | Removes only temporary files but retains execution log entries and metadata.   |                                           
+--------------------------+------------+--------------------------------------------------------------------------------+
| quiet                    |   false    | Do not print names of files removed.                                           |
+--------------------------+------------+--------------------------------------------------------------------------------+



Examples
^^^^^^^^^^^^^^^^^^^^
