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
; all the test, should be moved to test file

(comment
(def cell-a (Cell. nil nil false true))
(def cell-b (Cell. nil nil true true))
(def cell-c (Cell. nil nil true false))
(def cell-d (Cell. nil nil true false))

(count-alive [cell-a cell-b cell-c cell-d])
(count-alive [cell-a cell-b nil cell-c cell-d nil])

(def world-a [[1 2 3 4]
              [5 6 7 8]
              [9 10 11 12]
              [13 14 15 16]])

(get-neighbours world-a 1 1)
(get-neighbours world-a 0 0)
(get-neighbours world-a 3 3)


(def a (Cell. 0 0 false nil))
(def b (Cell. 1 0 false nil))
(def c (Cell. 2 0 false nil))

(def d (Cell. 0 1 false nil))
(def e (Cell. 1 1 true nil))
(def f (Cell. 2 1 true nil))

(def g (Cell. 0 2 false nil))
(def h (Cell. 1 2 true nil))
(def i (Cell. 2 2 false nil))


(def world [[a b c]
            [d e f]
            [g h i]])

)
