(ns core-async-cljs-loop-bug.core
  (:require
   [cljs.core.async])
  (:require-macros
   [cljs.core.async.macros :refer [go-loop]]))

;; does NOT compile
(comment

  (go-loop []
    (do
      (recur)
      1))

  )

;; compiles but SHOULD NOT
(go-loop []
  (when true
    (recur))
  1)

;; does NOT compile (illustrating non-async behavior)
(comment

  (loop []
    (when true
      (recur))
    1)

  )
