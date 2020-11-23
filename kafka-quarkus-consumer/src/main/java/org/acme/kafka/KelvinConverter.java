package org.acme.kafka;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.reactive.messaging.annotations.Broadcast;

@ApplicationScoped
public class KelvinConverter {

    @ConfigProperty(name = "kelvin-diff")
    Double kelvinDiff;

    @Incoming("temperature")
    @Outgoing("temperature-stream")
    @Broadcast
    @Acknowledgment(Acknowledgment.Strategy.PRE_PROCESSING)
    public double process(int temperatureInKelvin) {
        return temperatureInKelvin + kelvinDiff;
    }

}
