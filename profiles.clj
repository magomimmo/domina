{:dev {:resources-paths ["dev-resources"]
       :test-paths ["test/clj" "test/tools"]
       :clean-targets ^{:protect false} [:target-path "dev-resources/public/js"]
       :dependencies [[ring "1.4.0"]
                     [compojure "1.4.0"]
                     [com.cemerick/piggieback "0.2.1"]]

       :plugins [[com.cemerick/clojurescript.test "0.3.3"]]

       :cljsbuild
       {:builds {:whitespace
                 {:source-paths ["src/cljs" "test/cljs" "src/brepl"]
                  :compiler
                  {:output-to "dev-resources/public/js/whitespace.js"
                   :optimizations :whitespace
                   :pretty-print true}}

                 :simple
                 {:source-paths ["src/cljs" "test/cljs" "src/brepl"]
                  :compiler
                  {:output-to "dev-resources/public/js/simple.js"
                   :optimizations :simple
                   :pretty-print false}}

                 :advanced
                 {:source-paths ["src/cljs" "test/cljs"]
                  :compiler
                  {:output-to "dev-resources/public/js/advanced.js"
                   :optimizations :advanced
                   :pretty-print false}}}

        :test-commands {"slimerjs-ws"
                        ["slimerjs"
                         :runner
                         "dev-resources/public/js/whitespace.js"]

                        "slimerjs-simple"
                        ["slimerjs"
                         :runner
                         "dev-resources/public/js/simple.js"]

                        "slimerjs-advanced"
                        ["slimerjs"
                         :runner
                         "dev-resources/public/js/advanced.js"]

                        "phantomjs-ws"
                        ["phantomjs"
                         :runner
                         "dev-resources/public/js/whitespace.js"]

                        "phantomjs-simple"
                        ["phantomjs"
                         :runner
                         "dev-resources/public/js/simple.js"]

                        "phantomjs-advanced"
                        ["phantomjs"
                         :runner
                         "dev-resources/public/js/advanced.js"]}}

       :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
       :injections [(require '[cljs.repl.browser :as brepl]
                             '[cemerick.piggieback :as pb])
                    (defn browser-repl []
                      (pb/cljs-repl :repl-env
                                    (brepl/repl-env :port 9000)))]}}
