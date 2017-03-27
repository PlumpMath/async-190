(set-env!
 :source-paths #{"src"}
 :dependencies
 '[[adzerk/boot-cljs "1.7.228-2" :scope "test"]
   [adzerk/boot-cljs-repl "0.3.3" :scope "test"]
   [adzerk/boot-reload "0.5.1" :scope "test"]
   [org.clojure/clojure "1.9.0-alpha15"]
   [org.clojure/clojurescript "1.9.494"]
   [org.clojure/core.async "0.3.442"]
   [org.clojure/tools.nrepl "0.2.12" :scope "test"]])

(require
 '[adzerk.boot-cljs :refer :all]
 '[adzerk.boot-cljs-repl :refer :all]
 '[adzerk.boot-reload :refer :all])

(deftask dev
  "Run dev environment."
  []
  (comp (watch)
        (reload)
        (cljs :ids ["main"])
        (target)))

(deftask build-cljs
  "Build ClojureScript."
  []
  (comp (cljs :ids ["main"]
              :optimizations :whitespace)
        (target)))
