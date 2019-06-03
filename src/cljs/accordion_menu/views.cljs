(ns accordion-menu.views
  (:require [re-frame.core :as re-frame]
            [accordion-menu.subs :as subs]))

#_(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 "Hello from " @name]]))

(defn content-list [num more-num]
  [:li (str num "x" more-num " = " (* num more-num))])

(defn accordion-content [num]
  [:ul.acc-content
   (map #(content-list num %) (range 1 10))])

(defn list-accordion [num]
  [:div {:id num
         :key num}
   [:input.acc-toggle {:type "checkbox"
                       :id (str "toggle_" num)}]
   [:label.acc-label {:for (str "toggle_" num)}
    [:span (str num "の段")]]
   [accordion-content num]])

(defn main-panel []
  [:div.accbox
   (doall (map list-accordion (range 1 10)))])
