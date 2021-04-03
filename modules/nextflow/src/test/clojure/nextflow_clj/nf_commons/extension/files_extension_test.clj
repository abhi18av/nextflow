(ns nextflow-clj.nf-commons.extension.files-extension-test
  (:require [clojure.test :refer :all])
  (:import
    (java.nio.file Files Path Paths)
    (java.io File)
    (nextflow.extension FilesEx)))


(comment
  (FilesEx/getBaseName (File. "/path/file.txt"))

  (FilesEx/getExtension (File. "/path/file.txt"))

  '())
