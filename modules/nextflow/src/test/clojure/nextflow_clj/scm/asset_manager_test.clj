(ns nextflow-clj.scm.asset-manager-test
  (:require [clojure.pprint :as cpprint]
            [clojure.reflect :as creflect])
  (:import (nextflow.scm AssetManager)))

(comment
  (def ^AssetManager assetManager (AssetManager. "https://github.com/nextflow-io/rnaseq-nf"))

  (cpprint/print-table (:members (creflect/reflect assetManager)))

  (.download assetManager)

  (.getDefaultBranch assetManager  )

  (.getGitRepositoryUrl assetManager)

  (.getMainScriptFile assetManager )

  (.getHub assetManager )


  ;; RepositoryInfo
  (comment
    (.getCommitId (.getCurrentRevisionAndName assetManager))
    (.getName (.getCurrentRevisionAndName assetManager))
    )

  '())
