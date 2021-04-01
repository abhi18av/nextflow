(ns nextflow-clj.util.simple-http-client-test
  (:require [clojure.test :refer :all])
  (:import (nextflow.util SimpleHttpClient)))

(comment

  (let [httpClient (new SimpleHttpClient)
        url "http://localhost:3100"]
    (try
      (.sendHttpMessage httpClient url "{\"test_id\": 2}")
      #_(catch Exception e (println (.getMessage e))))
    #_(println (.getResponseCode httpClient)))


  (let [httpClient (new SimpleHttpClient)
        url "http://foo.bar"]
    (.sendHttpMessage httpClient url "{\"test_id\": 2}"))





  '())
