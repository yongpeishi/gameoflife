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

(defn alive-next [lively-neighbours alive-now]
  (or (== lively-neighbours 3)
      (and (== lively-neighbours 2)
           alive-now)))
(comment

(alive-next 0 true)
(alive-next 1 true)
(alive-next 2 true)
(alive-next 3 true)
(alive-next 4 true)
(alive-next 5 true)
(alive-next 6 true)
(alive-next 7 true)
(alive-next 8 true)
(alive-next 0 false)
(alive-next 1 false)
(alive-next 2 false)
(alive-next 3 false)
(alive-next 4 false)
(alive-next 5 false)
(alive-next 6 false)
(alive-next 7 false)
(alive-next 8 false)

)

