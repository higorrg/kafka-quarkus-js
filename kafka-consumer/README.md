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

## Anatomy

In addition to the `temperature.html` page, the application is composed by 3 components:

* `temperatureGenerator` - a bean generating random temperature. They are sent to a Kafka topic
* `temperatureConverter` - on the consuming side, the `temperatureConverter` receives the Kafka message and convert the temperature.
The result is sent to an in-memory stream of data
* `temperatureResource`  - the `temperatureResource` retrieves the in-memory stream of data in which the converted temperature are sent and send these temperature to the browser using Server-Sent Events.

The interaction with Kafka is managed by MicroProfile Reactive Messaging.
The configuration is located in the application configuration.

## Running in native

You can compile the application into a native binary using:

`mvn clean install -Pnative`

and run with:

`./target/kafka-quickstart-1.0-SNAPSHOT-runner` 