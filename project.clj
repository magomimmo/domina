(defproject org.clojars.magomimmo/domina "2.0.0-SNAPSHOT"
  :description "A DOM manipulation library for ClojureScript inspired by JQuery"
  :min-lein-version "2.5.3"

  :source-paths ["src/clj"]
  :clean-targets ^{:protect false} [:target-path "dev-resources/public/js"]

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]]

  :plugins [[lein-cljsbuild "1.1.1"]]

  :hooks [leiningen.cljsbuild]

  :cljsbuild {:builds {:deploy
                       {:source-paths ["src/cljs"]
                        :jar true
                        :compiler
                        {:output-to "dev-resources/public/js/deploy.js"
                         :optimizations :whitespace
                         :pretty-print true}}}})
