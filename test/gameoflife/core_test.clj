(ns gameoflife.core-test
  (:require [clojure.test :refer :all]
            [gameoflife.core :refer :all]))

;alive-next?

(deftest should-not-alive-next-when-0-neighbour-and-alive
  (is (false? (alive-next? 0 true))))

(deftest should-not-alive-next-when-1-neighbour-and-alive
  (is (false? (alive-next? 1 true))))

(deftest should-alive-next-when-2-neighbour-and-alive
  (is (true? (alive-next? 2 true))))

(deftest should-alive-next-when-3-neighbour-and-alive
  (is (true? (alive-next? 3 true))))

(deftest should-not-alive-next-when-4-neighbour-and-alive
  (is (false? (alive-next? 4 true))))

(deftest should-not-alive-next-when-5-neighbour-and-alive
  (is (false? (alive-next? 5 true))))

(deftest should-not-alive-next-when-6-neighbour-and-alive
  (is (false? (alive-next? 6 true))))

(deftest should-not-alive-next-when-7-neighbour-and-alive
  (is (false? (alive-next? 7 true))))

(deftest should-not-alive-next-when-8-neighbour-and-alive
  (is (false? (alive-next? 8 true))))

(deftest should-not-alive-next-when-0-neighbour-and-not-alive
  (is (false? (alive-next? 0 false))))

(deftest should-not-alive-next-when-1-neighbour-and-not-alive
  (is (false? (alive-next? 1 false))))

(deftest should-not-alive-next-when-2-neighbour-and-not-alive
  (is (false? (alive-next? 2 false))))

(deftest should-alive-next-when-3-neighbour-and-not-alive
  (is (true? (alive-next? 3 false))))

(deftest should-not-alive-next-when-4-neighbour-and-not-alive
  (is (false? (alive-next? 4 false))))

(deftest should-not-alive-next-when-5-neighbour-and-not-alive
  (is (false? (alive-next? 5 false))))

(deftest should-not-alive-next-when-6-neighbour-and-not-alive
  (is (false? (alive-next? 6 false))))

(deftest should-not-alive-next-when-7-neighbour-and-not-alive
  (is (false? (alive-next? 7 false))))

(deftest should-not-alive-next-when-8-neighbour-and-not-alive
  (is (false? (alive-next? 8 false))))


;
