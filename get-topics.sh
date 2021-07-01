#!/bin/bash
docker exec -it kafka_quarkus_js_broker_1 /opt/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9092 --list
