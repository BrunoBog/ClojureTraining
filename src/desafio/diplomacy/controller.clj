(ns desafio.diplomacy.controller
  (:require [io.pedestal.http.route :as route]
            [io.pedestal.http :as http]
            [io.pedestal.test :as test]
            [clojure.data.json :as json]
            [desafio.logic.brpages :as brpages])
  (:use clojure.pprint))

(defn list-page-by-country
  "select pages for a specific country"
  [country-code]
  (case country-code
    "br" brpages/listar-paginas))

(defn list-pages 
  "list pages from param"
  [request]
  (let  [query-param (get-in request [:query-params :country])]
    (if (boolean  query-param)
      (list-page-by-country query-param)
      {:status 400 :message "miss country parameter"})))

(defn register
  "Register a new client ( or deny)"
  [request]
  )

(def routes (route/expand-routes #{["/listpages" :get list-pages :route-name :listar-paginas]
                                   ["/register" :post register :route-name :criar-tarefa]}))
(def service-map {::http/routes routes
                  ::http/port   5160
                  ::http/type   :jetty
                  ::http/join?  false})

(defonce server (atom nil))

(defn start-server []
  (reset! server (http/start (http/create-server service-map))))

(defn stop-server [] (http/stop @server))
(defn restart-server [] (stop-server) (start-server))