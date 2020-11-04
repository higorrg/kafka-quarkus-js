#!/bin/bash
if [ ! -f kafka-consumer-1.0-SNAPSHOT-runner.jar ]; then
  mvn clean package
fi
java -Dkelvin-diff=-272.15 -Dtemperature-name=Celsius -Dquarkus.http.port=8082 -jar target/kafka-consumer-1.0-SNAPSHOT-runner.jar