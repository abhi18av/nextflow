(ns nextflow-clj.script.script-runner-test)

(comment
  (ns nextflow-clj.script.scriptRunnerTest
    (:import (nextflow.script ScriptRunner ScriptFile ScriptParser ScriptBinding)
             (nextflow.processor TaskConfig)
             (nextflow Session)
             (java.io File)))

  (def scriptRunner (ScriptRunner.))

  (def scriptFile (ScriptFile.
                    (File. "resources/helloWorld.nf")))

  (.setScript scriptRunner scriptFile)

  (comment
    (.execute scriptRunner)

    '())


  (def taskConfig (TaskConfig. {"time"          "1h"
                                "errorStrategy" "FINISH"
                                "maxRetries"    "3"
                                }))


  (def parsed-hello-script
    (.parse (ScriptParser.
              (.getSession scriptRunner))
            (.getText scriptFile)))


  (.getScript parsed-hello-script)

  (.setBinding parsed-hello-script (ScriptBinding.))

  (.start (Session.))

  (.runScript parsed-hello-script)

  (let [session (new Session)
        parser (new ScriptParser session)
        binding (new ScriptBinding)
        fileText (.getText (ScriptFile.
                             (File. "resources/hello.nf")))]
    (doto
      (.setBinding parser binding)
      (.runScript fileText)))




  '())


