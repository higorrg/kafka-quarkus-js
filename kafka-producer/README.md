Quarkus Kafka Quickstart
========================

This project illustrates how you can interact with Apache Kafka using MicroProfile Reactive Messaging.

## Kafka cluster

First you need a Kafka cluster. You can follow the instructions from the [Apache Kafka web site](https://kafka.apache.org/quickstart) or run `docker-compose up` if you have docker installed on your machine.

## Start the application

The application can be started using: 

```bash
mvn quarkus:dev
```  

Then, open your browser to `http://localhost:8080/temperature.html`, and you should see a fluctuating temperature.

docker exec -it kafka-single-node_kafka_1 /opt/kafka/bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic temperature

docker exec -it kafka-single-node_kafka_1 /opt/kafka/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic temperature