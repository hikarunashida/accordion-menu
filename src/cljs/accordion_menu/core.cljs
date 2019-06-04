(ns accordion-menu.core
  (:require [reagent.core :as reagent]
            [accordion-menu.views :as views]
            [accordion-menu.config :as config]))

(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (dev-setup)
  (mount-root))
