#!/bin/bash
if [ ! -target/quarkus-app/quarkus-run.jar ]; then
  mvn clean package
fi
java -Dkelvin-diff=-457.87 -Dtemperature-name=Fahrenheit -Dquarkus.http.port=8083 -jar target/quarkus-app/quarkus-run.jar
