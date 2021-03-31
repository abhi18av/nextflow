(ns config.ConfigParserTest
  (:require [clojure.test :refer :all])
  (:import (nextflow.config ConfigParser)))

(deftest scratch-test
  (testing "Parses the config text cleanly"
    (let [CONFIG "mem1 = 1.GB"
          result (.parse (ConfigParser.) CONFIG)]
      (is "1 GB" (.get result "mem1")))))
