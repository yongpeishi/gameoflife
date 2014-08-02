(ns gameoflife.core
  (:require [alex-and-georges.debug-repl :refer [debug-repl]]))


; RULES
; Any live cell with fewer than two live neighbours dies, as if caused by under-population.
; Any live cell with more than three live neighbours dies, as if by overcrowding.

; Any live cell with two or three live neighbours lives on to the next generation.
; Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

; FLOW
; loop trough the given world
; get the collection of neighbours
; count neighbours that's alive
; decide if cell is alive on next generation
; draw world and update status of each cell (alive or not)
; repeat


(defrecord Cell [x y alive-now alive-next])

(defn get-cell [world x y]
  (nth (nth world y) x))

(defn get-neighbours [world x y]
  (let [size (count world)]
    (for [[dx dy] [[-1 -1] [0 -1] [1 -1]
                   [-1 0]         [1 0]
                   [-1 1]  [0 1]  [1 1]]]
      (let [nx (+ x dx)
            ny (+ y dy)]
        (if-not (or (neg? nx) (>= nx size) (neg? ny) (>= ny size))
          (get-cell world nx ny))))))

(defn count-alive [neighbours]
  (count (filter :alive-now neighbours)))

(defn alive-next? [num-alive-neighbours alive-now]
  (or (== num-alive-neighbours 3)
      (and (== num-alive-neighbours 2)
           alive-now)))

(defn cal-next-gen [world]
  (map (fn [row]
         (map (fn [cell]
             (let [neighbours (get-neighbours world (:x cell) (:y cell))]
               (assoc cell :alive-next (alive-next? (count-alive neighbours) (:alive-now cell)))
               ))
           row))
       world))


(defn new-world [calculated-gen]
  (println calculated-gen)
  (map (fn [row]
         (map (fn [cell]
             ;; draw the cell here
             (assoc cell :alive-now (:alive-next cell) :alive-next nil))
           row))
       calculated-gen))

(defn next-gen [world]
  (new-world (cal-next-gen world)))


;; -----------------------------------------------------------------

(def c00 (Cell. 0 0 false nil))
(def c10 (Cell. 1 0 true  nil))
(def c20 (Cell. 2 0 false nil))

(def c01 (Cell. 0 1 false nil))
(def c11 (Cell. 1 1 true nil))
(def c21 (Cell. 2 1 false nil))

(def c02 (Cell. 0 2 false nil))
(def c12 (Cell. 1 2 true nil))
(def c22 (Cell. 2 2 false nil))

(def vertical-world [[c00 c10 c20]
            [c01 c11 c21]
            [c02 c12 c22]])


(def c00 (Cell. 0 0 false nil))
(def c10 (Cell. 1 0 false  nil))
(def c20 (Cell. 2 0 false nil))

(def c01 (Cell. 0 1 true nil))
(def c11 (Cell. 1 1 true nil))
(def c21 (Cell. 2 1 true nil))

(def c02 (Cell. 0 2 false nil))
(def c12 (Cell. 1 2 false nil))
(def c22 (Cell. 2 2 false nil))

(def horizontal-world [[c00 c10 c20]
            [c01 c11 c21]
            [c02 c12 c22]])


(= (take 10 (cycle [vertical-world horizontal-world]))
   (take 10 (iterate next-gen vertical-world)))

(defn -main []
  (take 10 (iterate next-gen vertical-world))


;; -----------------------------------------------------------------


;(comment
; all the test, should be moved to test file

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

(comment

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

