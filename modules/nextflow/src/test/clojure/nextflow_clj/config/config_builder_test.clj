(ns nextflow-clj.config.config-builder-test
  (:require [clojure.test :refer :all]))


(comment
  (ns nextflow-clj.config.configBuilderTest
    (:require [clojure.java.data :as jv]
              [clojure.inspector :as insp])
    (:import (nextflow.config ConfigBuilder)))

  (def configBuilder (new ConfigBuilder))



  (->
    configBuilder
    bean)


  (clojure.pprint/print-table (:members (clojure.reflect/reflect configBuilder)))


  (.buildConfig0 configBuilder (java.util.HashMap. {"PATH" "/local/bin"}) nil)


  (.getBaseDir configBuilder)

  (clojure.pprint/print-table (:members (clojure.reflect/reflect configBuilder)))

  (.build (ConfigBuilder.))

  (bean (ConfigBuilder.))

  (bean (.setProfile (new ConfigBuilder) "root"))

  '())
