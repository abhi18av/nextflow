(ns nextflow-clj.config.manifest-test
  (:require [clojure.test :refer :all])
  (:import (nextflow.config Manifest)
           (java.util HashMap)
           (groovy.util ConfigObject)))

(comment
  ;; DONE
  '())

(deftest check-manifest-from-map
  (testing "should check manifest object"
    (let [manifest-map {"author"          "Pablo"
                        "nextflowVersion" "1.2.3"
                        "name"            "fooo"}
          manifest-obj (Manifest. (HashMap. manifest-map))]
      (is (= "Pablo" (:author (bean manifest-obj))))
      (is (= "1.2.3" (:nextflowVersion (bean manifest-obj))))
      (is (= "fooo" (:name (bean manifest-obj)))))))


(deftest check-empty-manifest
  (testing "should check empty manifest"
    (let [manifest-obj (Manifest. (ConfigObject.))]
      (is (= nil (:homePage (bean manifest-obj))))
      (is (= "master" (:defaultBranch (bean manifest-obj))))
      (is (= nil (:description (bean manifest-obj))))
      (is (= nil (:author (bean manifest-obj))))
      (is (= "main.nf" (:mainScript (bean manifest-obj))))
      (is (= nil (:gitmodules (bean manifest-obj))))
      (is (= nil (:nextflowVersion (bean manifest-obj))))
      (is (= nil (:version (bean manifest-obj))))
      (is (= nil (:name (bean manifest-obj)))))))


