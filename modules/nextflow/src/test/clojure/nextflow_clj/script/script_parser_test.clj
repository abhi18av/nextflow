(ns nextflow-clj.script.script-parser-test)

(comment
  (ns nextflow-clj.script.scriptParserTest
    (:import (nextflow.script ScriptParser ScriptBinding)))



  (.parse (ScriptParser) (ScriptFile.
                           (java.io.File. "resources/hello.nf")
                           ))

  (ScriptFile.
    (java.io.File. "resources/hello.nf")
    )


  (def session (Session.))
  (def parser (ScriptParser. session))
  (def binding (ScriptBinding.))



  '())
