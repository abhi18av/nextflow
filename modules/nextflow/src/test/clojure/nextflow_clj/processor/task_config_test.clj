(ns nextflow-clj.processor.task-config-test)

(comment

  (ns nextflow-clj.processor.taskConfig
    (:require [clojure.java.data :as jv]
              [clojure.inspector :as insp])
    (:import (nextflow.processor TaskConfig)))

  (def taskConfig (TaskConfig. {"time"          "1h"
                                "errorStrategy" "FINISH"
                                "maxRetries"    "3"
                                }))

  (.setContext taskConfig (java.util.HashMap. {"my_shell" "hello"}))

  (bean taskConfig)

  (.getShell taskConfig)

  (.getErrorStrategy taskConfig)

  '())
