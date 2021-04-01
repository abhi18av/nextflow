(ns nextflow-clj.processor.task-context-test)

(comment

  (ns nextflow-clj.processor.taskContext
    (:require [clojure.java.data :as jv]
              [clojure.inspector :as insp])
    (:import (nextflow.processor TaskContext)))

  (def taskContext (TaskContext.))

  (bean taskContext)



  '())
