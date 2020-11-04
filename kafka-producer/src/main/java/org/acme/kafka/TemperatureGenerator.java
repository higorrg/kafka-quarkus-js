package org.acme.kafka;

import java.time.Duration;
import java.util.Random;

import javax.enterprise.context.ApplicationScoped;

import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

/**
 * A bean producing random temperature every 5 seconds.
 * The temperature are written to a Kafka topic (temperature). The Kafka configuration is specified in the application configuration.
 */
@ApplicationScoped
public class TemperatureGenerator {

    private Random random = new Random();

    @Outgoing("generated-temperature")
    public Multi<Integer> generate() {
        return Multi.createFrom().ticks().every(Duration.ofSeconds(1))
                .onOverflow().drop()
                .map(tick -> random.nextInt(100));
    }

}
