#!/bin/bash
if [ ! -f target/kafka-quarkus-consumer-1.0-SNAPSHOT-runner.jar ]; then
  echo "Clean Package"
  mvn clean package
fi
java -Dkelvin-diff=-272.15 -Dtemperature-name=Celsius -Dquarkus.http.port=8082 -jar target/kafka-quarkus-consumer-1.0-SNAPSHOT-runner.jar
