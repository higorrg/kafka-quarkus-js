#!/bin/bash
if [ ! -f target/quarkus-app/quarkus-run.jar ]; then
  mvn clean package
fi
java -Dkelvin-diff=-272.15 -Dtemperature-name=Celsius -Dquarkus.http.port=8082 -jar target/quarkus-app/quarkus-run.jar
