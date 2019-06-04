(ns accordion-menu.core
  (:require [reagent.core :as reagent]))

;; view

(defn content-list [num1 num2]
  [:li {:key (str num1 "x" num2)}
   (str num1 "x" num2 " = " (* num1 num2))])

(defn accordion-list [num]
  (let [default-idx 3
        content-list* (partial content-list num)]
    [:div {:id num :key num}
     [:input.acc-toggle {:type "checkbox"
                         :id (str "toggle_" num)
                         :default-checked (= num default-idx)}]
     [:label.acc-label {:for (str "toggle_" num)}
      [:span (str num "の段")]]
     [:div.acc-content
      [:ul
       (map content-list* (range 1 10))]]]))

(defn accordion-menu []
  [:div.accbox
   [:h1 "Accordion Menu"]
   (map accordion-list (range 1 10))])

;; initialization

(defn dev-setup []
  (when ^boolean goog.DEBUG
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (reagent/render [accordion-menu]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (dev-setup)
  (mount-root))
