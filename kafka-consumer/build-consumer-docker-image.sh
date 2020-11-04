#!/bin/bash
mvn clean package
docker build -f src/main/docker/Dockerfile.jvm -t kafka-quarkus-js-producer .
