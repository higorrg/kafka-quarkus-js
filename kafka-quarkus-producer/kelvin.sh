#!/bin/bash
if [ ! -f target/kafka-quarkus-producer-1.0-SNAPSHOT-runner.jar ]; then
  mvn clean package
fi
java -jar target/kafka-quarkus-producer-1.0-SNAPSHOT-runner.jar
