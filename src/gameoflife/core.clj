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


(defrecord Cell [alive-now alive-next])

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
  (loop [row-num 0]
    (when (< row-num size)

      (loop [col-num 0]
        (when (< col-num size)
          (let [cell (get-cell world col-num row-num)
                neighbours (get-neighbours world size col-num row-num)]
            (assoc cell :alive-next (alive-next (count-alive neighbours) (:alive-now cell))))
          (recur (inc col-num))
      ))

      (recur (inc row-num))
   )))

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

(def cell-a (Cell. false true))
(def cell-b (Cell. true true))
(def cell-c (Cell. true false))
(def cell-d (Cell. true false))

(count-alive [cell-a cell-b cell-c cell-d])
(count-alive [cell-a cell-b nil cell-c cell-d nil])

(def world-a [[1 2 3 4]
            [5 6 7 8]
            [9 10 11 12]
            [13 14 15 16]])

(get-neighbours world-a 4 1 1)
(get-neighbours world-a 4 0 0)
(get-neighbours world-a 4 3 3)

(def a (Cell. false nil))
(def b (Cell. false nil))
(def c (Cell. false nil))

(def d (Cell. false nil))
(def e (Cell. true nil))
(def f (Cell. true nil))

(def g (Cell. false nil))
(def h (Cell. true nil))
(def i (Cell. false nil))


(def world-b [[a b c]
              [d e f]
              [g h i]])

(def new-world (cal-next-gen world-b 3))
new-world
world-b

)

