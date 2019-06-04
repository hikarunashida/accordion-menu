(defproject accordion-menu "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.520"]
                 [reagent "0.8.1"]]
  :plugins [[lein-cljsbuild "1.1.7"]
            [deraen/lein-sass4clj "0.3.1"]]
  :min-lein-version "2.5.3"
  :source-paths ["src/clj" "src/cljs"]
  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]
  :figwheel {:css-dirs ["resources/public/css"]}
  :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}
  :profiles {:dev
             {:dependencies [[binaryage/devtools "0.9.10"]
                             [figwheel-sidecar "0.5.16"]
                             [cider/piggieback "0.4.0"]
                             [org.slf4j/slf4j-nop "1.7.13" :scope "test"]]
              :plugins      [[lein-figwheel "0.5.18"]]
              :source-paths ["src/cljs" "env/dev/clj"]
              :repl-options {:init-ns accordion-menu.repl
                             :nrepl-middleware [cider.piggieback/wrap-cljs-repl]}}
             :prod {}}
  :cljsbuild {:builds [{:id           "dev"
                        :source-paths ["src/cljs"]
                        :figwheel     {:on-jsload "accordion-menu.core/mount-root"}
                        :compiler     {:main                 accordion-menu.core
                                       :output-to            "resources/public/js/compiled/app.js"
                                       :output-dir           "resources/public/js/compiled/out"
                                       :asset-path           "js/compiled/out"
                                       :source-map-timestamp true
                                       :preloads             [devtools.preload]
                                       :external-config      {:devtools/config {:features-to-install :all}}}}
                       {:id           "min"
                        :source-paths ["src/cljs"]
                        :compiler     {:main            accordion-menu.core
                                       :output-to       "resources/public/js/compiled/app.js"
                                       :optimizations   :advanced
                                       :closure-defines {goog.DEBUG false}
                                       :pretty-print    false}}]}
  :sass {:source-paths ["src/scss"]
         :target-path "resources/public/css"
         :output-style :compressed})
