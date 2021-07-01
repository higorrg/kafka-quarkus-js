package org.acme.kafka;

import java.time.Duration;
import java.util.Random;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.smallrye.mutiny.Multi;

/**
 * A bean producing random temperature every 5 seconds.
 * The temperature are written to a Kafka topic (temperature). The Kafka configuration is specified in the application configuration.
 */
@ApplicationScoped
public class TemperatureGenerator {

	private static final Logger logger = LoggerFactory.getLogger(TemperatureGenerator.class);
    private Random random = new Random();

    @Outgoing("generated-temperature")
    public Multi<Integer> generate() {
		return Multi.createFrom()
				.ticks()
				.every(Duration.ofSeconds(1))
                .onOverflow().drop()
				.map(tick -> {
					var randomTemperature = random.nextInt(100);
					logger.info("Generated Temperature: " + randomTemperature);
					return randomTemperature;
				});
    }

}
