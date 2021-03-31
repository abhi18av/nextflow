(ns nextflow-clj.config.config-parser-test
  (:require [clojure.test :refer :all])
  (:import (nextflow.config ConfigParser)))

(deftest scratch-test
  (testing "Parses the config text cleanly"
    (let [CONFIG "mem1 = 1.GB"
          result (.parse (ConfigParser.) CONFIG)]
      (is "1 GB" (.get result "mem1")))))

(defn scratch-get-field-from-config-text
  [config-string field-name]
  (let [result (.parse (ConfigParser.) config-string)]
    (.get result field-name)))

(comment
  (let [CONFIG "mem1 = 1.GB"]
    (println (scratch-get-field-from-config-text CONFIG "mem1")))
  )

(deftest scratch-function-test
  (testing "Parses the config text cleanly"
    (let [CONFIG "mem1 = 1.GB"]
      (is "1 GB" (scratch-get-field-from-config-text CONFIG "mem1")))))
