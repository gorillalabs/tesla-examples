(defproject gorillalabs.tesla.examples/simple "0.1.0"
  :description "a simple example of an application build with tesla."
  :url "https://github.com/gorillalabs/tesla-examples"
  :license {:name "Apache License 2.0"
            :url  "http://www.apache.org/license/LICENSE-2.0.html"}
  :scm {:name "git"
        :url  "https://github.com/gorillalabs/tesla"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [gorillalabs.tesla/core "1.0.0-alpha2"]
                 [org.slf4j/slf4j-api "1.7.12"]
                 [ch.qos.logback/logback-core "1.1.3"]
                 [ch.qos.logback/logback-classic "1.1.3"]]
  :main ^:skip-aot gorillalabs.tesla.example)
