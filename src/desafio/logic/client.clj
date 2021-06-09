(ns desafio.logic.client
  (:require [desafio.logic.brpages :as brpages]))

(defn register-client 
  "register a new client"
  [client]
  (if (valid? client)
    ()))

(defn valid?
  "verify if is a valid client"
  [client]
  (let [email (get client :email)]
    (if (compare email "birubiru")
      0 ; true
      1)))