(ns nextflow-clj.splitter.csv-splitter-test)

(comment

  (ns nextflow-clj.splitter.csvSplitterTest
    (:require [clojure.test :refer :all])
    (:import (org.codehaus.groovy.runtime StringGroovyMethods)
             (nextflow.splitter CsvSplitter)))

  (deftest a-test
           (let
             [text (.trim (StringGroovyMethods/stripIndent
                            "
                            alpha,beta,delta
                            gamma,,zeta
                            eta,theta,iota
                            mu,nu,xi
                            pi,rho,sigma
                            "))]
             (is (= (first (.list (.target (new CsvSplitter) text)))
                    ["alpha" "beta" "delta"]))

             ;; TODO create a java map in clojure
             (is (= (first (.list (.target (new CsvSplitter {"by" 3}) text)))
                    ["alpha" "beta" "delta"]))))







  '())
