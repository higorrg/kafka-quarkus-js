#!/bin/bash
java -Dkelvin-diff=-457.87 -Dtemperature-name=Fahrenheit -Dquarkus.http.port=8083 -jar target/kafka-consumer-1.0-SNAPSHOT-runner.jar
