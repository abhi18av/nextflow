(ns nextflow-clj.config.manifest-test
  (:import (nextflow.config Manifest)))

(def manifest-map {"author"          "Pablo"
                   "nextflowVersion" "1.2.3"
                   "name"            "fooo"})

(def manifest-obj (new Manifest
                       (java.util.HashMap. manifest-map)))

(bean manifest-obj)

