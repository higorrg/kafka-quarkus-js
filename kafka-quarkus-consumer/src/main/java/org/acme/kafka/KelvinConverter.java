package org.acme.kafka;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

@ApplicationScoped
public class KelvinConverter {

    @ConfigProperty(name = "kelvin-diff")
    Double kelvinDiff;

    @Incoming("temperature")
    @Outgoing("temperature-stream")
	@Acknowledgment(Acknowledgment.Strategy.POST_PROCESSING)
    public double process(int temperatureInKelvin) {
        return temperatureInKelvin + kelvinDiff;
    }

}
