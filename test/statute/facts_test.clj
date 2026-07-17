(ns statute.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [statute.facts :as facts]))

(deftest pol-has-spec-basis
  (let [sb (facts/spec-basis "POL")]
    (is (= 3 (count sb)))
    (is (every? #(str/starts-with? (:statute/url %) "https://") sb))
    (is (every? :statute/law-number sb))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["POL" "JPN" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL" "JPN"] (:missing-jurisdictions c)))))

(deftest by-topic-filters
  (is (= ["pol.dz-u-2018-1000-ochrona-danych-osobowych"]
         (mapv :statute/id (facts/by-topic "POL" :privacy))))
  (is (= ["pol.dz-u-1974-141-kodeks-pracy"]
         (mapv :statute/id (facts/by-topic "POL" :labor))))
  (is (empty? (facts/by-topic "ATL" :privacy))))
