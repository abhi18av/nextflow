(ns nextflow-clj.test-utils
  (:require [clojure.test :refer :all]
            [clojure.datafy :as d]
            [clojure.core.protocols :as p]))

(comment
  (require '[portal.api :as portal])

  (portal/open {:portal.colors/theme :portal.colors/solarized-light})


  (portal/tap)

  (defrecord SomeData [name children]
    p/Datafiable
    (datafy [r] {:class "SomeData" :name name}))


  (SomeData. "hello" [1 2 3])

  (d/datafy (SomeData. "hello" [1 2 3]))


  (add-tap #'portal/submit)


  (portal/clear)
  (portal/close)


  (tap> :hello)

  (tap> (SomeData. "hello" [1 2 3]))



  (dotimes [i 10]
    ;#dbg
    (prn i))

  '())

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))
