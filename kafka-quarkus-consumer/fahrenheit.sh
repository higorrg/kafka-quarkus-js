#!/bin/bash
if [ ! -f target/quarkus-app/quarkus-run.jar ]; then
  echo "Clean Package"
  mvn clean package
fi
java -Dkelvin-diff=-457.87 -Dtemperature-name=Fahrenheit -Dquarkus.http.port=8083 -jar target/quarkus-app/quarkus-run.jar
