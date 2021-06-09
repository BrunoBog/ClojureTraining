(ns desafio.models.models)

(defn nova-pagina [children botton]
  {
   :children children
   :botton botton
  })

(defn novo-header [title subtitle]
  "Nudes Header"
  {:type "Header"
   :title title
   :subtitle subtitle})

(defn novo-input
  "NudesInput"
  [keyboard id]
  {:type "Input"
   :keyboard keyboard
   :id id})

(defn novo-button
  "Nudes button"
  [text]
  {:type "BottomButton"
   :text text})

(defn nova-action
  "represent a action from button"
  [method uri]
  {:method method
   :uri uri})
