(ns nextflow-clj.scm.asset-manager-test
  (:require [clojure.pprint :as cpprint]
            [clojure.reflect :as creflect])
  (:use (nextflow.extension))
  (:import (nextflow.scm AssetManager)
           (test TemporaryPath)))

(comment
  (def assetManager (AssetManager. "https://github.com/nextflow-io/rnaseq-nf"))

  (cpprint/print-table (:members (creflect/reflect assetManager)))

  (.download assetManager)

  (.getDefaultBranch assetManager)

  (.getGitRepositoryUrl assetManager)

  (.getMainScriptFile assetManager)

  (.getHub assetManager)

  (.getBaseName ^AssetManager assetManager)


  (.isLocal assetManager)
  (.getManifest assetManager)

  (.getRevisions ^AssetManager assetManager 1)

  (.getCurrentRevisionAndName assetManager)

  (AssetManager/list)

  (def temp-dir (TemporaryPath.))

  (.create ^TemporaryPath temp-dir)
  (.toFile ^java.nio.file.Path (.getRoot ^TemporaryPath temp-dir))

  (def foldr (.getRoot temp-dir))
  (.resolve ^java.nio.file.Path foldr "cbcrg/pipe1")

  (.isDirectory (.resolve foldr "cbcrg/pipe1"))

  ;; RepositoryInfo
  (comment
    (.getCommitId (.getCurrentRevisionAndName assetManager))
    (.getName (.getCurrentRevisionAndName assetManager))
    )

  '())
