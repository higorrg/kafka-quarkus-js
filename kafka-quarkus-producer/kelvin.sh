#!/bin/bash
if [ ! -f target/quarkus-app/quarkus-run.jar ]; then
  mvn clean package
fi
java -jar target/quarkus-app/quarkus-run.jar
