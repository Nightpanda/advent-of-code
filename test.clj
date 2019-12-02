(ns test
  (:require [clojure.test :refer :all]
            [main :refer [fuel-for-mass
                          fuel-requirement-for-modules
                          fuel-for-fuel
                          total-mass]]))

(deftest fuel-for-fuel-test
  (is (= 0 (fuel-for-fuel 2)))
  (is (= (+ 216 70 21 5) (fuel-for-fuel 654)))
  (is (= (+ 11192 3728 1240 411 135 43 12 2) (fuel-for-fuel 33583))))

(deftest total-mass-test
  (is (= 2 (total-mass 12)))
  (is (= 50346 (total-mass 100756))))

(deftest fuel-for-mass-test
  (is (= 2 (fuel-for-mass 12)))
  (is (= 2 (fuel-for-mass 14)))
  (is (= 654 (fuel-for-mass 1969)))
  (is (= 33583 (fuel-for-mass 100756))))

(deftest fuel-requirement-for-modules-test
  (is (= 4 (fuel-requirement-for-modules [12 14])))
  (is (= 658 (fuel-requirement-for-modules [12 14 1969]))))
