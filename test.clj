(ns test
  (:require [clojure.test :refer :all]
            [main :refer [fuel-for-mass
                          fuel-requirement-for-modules
                          fuel-for-fuel
                          total-mass]]
            [intcode :refer [parse-opcode
                             add-operation
                             multiply-operation
                             parse-code]]))

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

(deftest parse-opcode-test
  (is (= 1 (parse-opcode [1 0 0 3 99]))))

(deftest add-operation-test
  (is (= [2 0 0 0 99] (add-operation [1 0 0 0 99]))))

(deftest multiply-operation-test
  (is (= [2 3 0 6 99] (multiply-operation [2 3 0 3 99])))
  (is (= [2 4 4 5 99 9801] (multiply-operation [2 4 4 5 99 0]))))

(deftest parse-code-test
  (is (= [30 1 1 4 2 5 6 0 99] (parse-code [1 1 1 4 99 5 6 0 99]))))
