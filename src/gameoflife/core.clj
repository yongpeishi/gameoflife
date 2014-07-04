(ns gameoflife.core)

; RULES
; Any live cell with fewer than two live neighbours dies, as if caused by under-population.
; Any live cell with more than three live neighbours dies, as if by overcrowding.

; Any live cell with two or three live neighbours lives on to the next generation.
; Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

; FLOW
; loop trough world
; get the collection of neighbours
; count neighbours that's alive
; decide if cell is alive on next generation
; draw world and update status of each cell (alive or not)

(defn get-neighbours [world size x y]
  (let [dxdy [[-1 -1] [0 -1] [1 -1]
              [-1 0]         [1 0]
              [-1 1]  [0 1]  [1 1]]]
    (map (fn [[dx dy]]
           (let [nx (+ x dx)
                 ny (+ y dy)]
             (if-not (or (neg? nx) (>= nx size) (neg? ny) (>= ny size))
               (get-cell world nx ny))))
         dxdy)))


(defrecord Cell [x y alive-now alive-next])

(defn get-cell [world x y]
  (nth (nth world y) x))

(defn count-alive [neighbours]
  (count
   (filter (fn [cell]
             (true? (:alive-now cell)))
           neighbours)))

(defn alive-next? [lively-neighbours alive-now]
  (or (== lively-neighbours 3)
      (and (== lively-neighbours 2)
           alive-now)))

(defn cal-next-gen [world size]
  (map (fn [row]
         (map (fn [cell]
             (let [neighbours (get-neighbours world size (:x cell) (:y cell))]
               (assoc cell :alive-next (alive-next? (count-alive neighbours) (:alive-now cell)))
               ))
           row))
       world))

(defn draw [world]
  (map (fn [row]
         (map (fn [cell]
                (let [alive (:alive-next cell)]
                  (if alive
                    (print "#")
                    (print " ")))
                (assoc cell :alive-now (:alive-next cell) :alive-next nil))
               row))
       world))

(comment

(alive-next? 0 true)
(alive-next? 1 true)
(alive-next? 2 true)
(alive-next? 3 true)
(alive-next? 4 true)
(alive-next? 5 true)
(alive-next? 6 true)
(alive-next? 7 true)
(alive-next? 8 true)
(alive-next? 0 false)
(alive-next? 1 false)
(alive-next? 2 false)
(alive-next? 3 false)
(alive-next? 4 false)
(alive-next? 5 false)
(alive-next? 6 false)
(alive-next? 7 false)
(alive-next? 8 false)

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

(get-neighbours world-a 4 1 1)
(get-neighbours world-a 4 0 0)
(get-neighbours world-a 4 3 3)

(def a (Cell. 0 0 false nil))
(def b (Cell. 1 0 false nil))
(def c (Cell. 2 0 false nil))

(def d (Cell. 0 1 false nil))
(def e (Cell. 1 1 true nil))
(def f (Cell. 2 1 true nil))

(def g (Cell. 0 2 false nil))
(def h (Cell. 1 2 true nil))
(def i (Cell. 2 2 false nil))


(def world-b [[a b c]
              [d e f]
              [g h i]])

(def new-world (cal-next-gen world-b 3))

new-world

world-b


(def world-drawn (draw new-world))

world-drawn


)

