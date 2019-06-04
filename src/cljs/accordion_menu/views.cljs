(ns accordion-menu.views)

(defn content-list [num more-num]
  [:li {:key (str num "x" more-num)}
   (str num "x" more-num " = " (* num more-num))])

(defn list-accordion [num]
  [:div {:id num
         :key num}
   [:input.acc-toggle {:type "checkbox"
                       :id (str "toggle_" num)}]
   [:label.acc-label {:for (str "toggle_" num)}
    [:span (str num "の段")]]
   [:div.acc-content
    [:ul
     (map #(content-list num %) (range 1 10))]]])

(defn main-panel []
  [:div.accbox
   (doall (map list-accordion (range 1 10)))])
