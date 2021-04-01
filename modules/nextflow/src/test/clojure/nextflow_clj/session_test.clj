(ns nextflow-clj.session-test)

(comment

  (ns nextflow-clj.sessionTest
    (:require [clojure.java.data :as jv]
              [clojure.inspector :as insp])
    (:import (nextflow Session)
             (nextflow.script ScriptFile)))

  (bean Session)

  (type Session)




  (.getSimpleName Session)

  (def scriptFile
    (ScriptFile.
      (java.io.File. "resources/hello.nf")
      )
    )

  (.getText scriptFile)

  (def session-init (.init (Session.) scriptFile))

  (.getConfigEnv session-init)

  (.getUniqueId session-init)
  (.getDag session-init)

  (.getParams (Session.))
  (.getPoolSize (Session.))

  (.start (Session.))


  '())
