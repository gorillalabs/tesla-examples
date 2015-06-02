(ns de.otto.tesla.example.example-system
  (:require [de.otto.tesla.system :as system]
            [de.otto.tesla.example.calculating :as calculating]
            [de.otto.tesla.stateful.configuring :as config]
            [gorillalabs.config :as c]
            [de.otto.tesla.example.page :as page]
            [com.stuartsierra.component :as component])
  (:gen-class))

(defn example-calculation-function [input]
  (.toUpperCase input))

(defn example-system [runtime-config]
  (-> (system/base-system (merge {:name "example-service"} runtime-config))
      (assoc :config (component/using (config/new-config runtime-config :load-config-fn (fn [_] (c/init)))  [:keep-alive]))
      (assoc :calculator
             (component/using (calculating/new-calculator example-calculation-function) [:metering :app-status]))
      (assoc :example-page
             (component/using (page/new-page) [:handler :calculator :app-status]))
      (component/system-using {:server [:example-page]})))

(defn -main
  "starts up the production system."
  [& args]
  (system/start-system (example-system {})))
