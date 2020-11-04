#!/bin/bash
if [ ! -f kafka-producer-1.0-SNAPSHOT-runner.jar ]; then
  mvn clean package
fi
java -jar target/kafka-producer-1.0-SNAPSHOT-runner.jar
