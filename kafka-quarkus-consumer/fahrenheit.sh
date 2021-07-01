#!/bin/bash
if [ ! -f target/kafka-quarkus-consumer-1.0-SNAPSHOT-runner.jar ]; then
  echo "Jar not found: Clean Package"
  mvn clean package
fi
java -Dkelvin-diff=-457.87 -Dtemperature-name=Fahrenheit -Dquarkus.http.port=8083 -jar target/kafka-quarkus-consumer-1.0-SNAPSHOT-runner.jar
