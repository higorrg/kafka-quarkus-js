package org.acme.kafka;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.SseElementType;
import org.reactivestreams.Publisher;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Channel;

@Path("/temperature")
public class TemperatureResource {

    @Inject
    @Channel("temperature-stream")
    Publisher<Double> temperature;

    @ConfigProperty(name = "temperature-name")
    String temperatureName;

    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @SseElementType("text/plain")
    public Publisher<Double> stream() {
        return temperature;
    }

    @GET
    @Path("/name")
    @Produces("text/plain")
    public String getTemperatureName(){
        return this.temperatureName;
    }

}
