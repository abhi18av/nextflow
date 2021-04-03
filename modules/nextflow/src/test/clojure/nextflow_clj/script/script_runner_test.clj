(ns nextflow-clj.script.script-runner-test
  (:require [clojure.test :refer :all])
  #_(:import (nextflow.script TestScriptRunner)
      (java.util HashMap)))

;; DONE
;; NOTE: Uncommenting the code fails the build since TestScriptRunner won't be found

#_(deftest test-script-runner

    (testing "test process"
      (let [script "process sayHello  {\"echo Hello world\"}"
            runner (TestScriptRunner. (HashMap. {"process" {"executor" "nope"}}))
            result (bean (.execute (.setScript ^TestScriptRunner runner script)))]
        (is (= "echo Hello world" (:val result)))))


    (testing "test process with args"
      (let [script " process task2  {\n
                    input:\n
                    val x from 1\n
                    val y from ([3])\n
                    output:\n
                    stdout result\n\n
                    \"\"\"echo $x - $y\"\"\"\n
                    } "
            runner (TestScriptRunner. (HashMap. {"process" {"executor" "nope"}}))
            result (bean (.execute (.setScript ^TestScriptRunner runner script)))]
        (is (= "echo 1 - 3" (:val result)))))

    )


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


