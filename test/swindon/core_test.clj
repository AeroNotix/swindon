(ns swindon.core-test
  (:require [clojure.test :refer :all]
            [swindon.core :refer :all]))

(deftest zipunzip
  (is (= true (java.util.Arrays/equals
               (unzip (zip (byte-array 10)))
               (byte-array 10)))))
