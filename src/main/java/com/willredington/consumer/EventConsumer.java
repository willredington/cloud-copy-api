package com.willredington.consumer;

import com.willredington.dto.StringEvent;
import javax.enterprise.context.ApplicationScoped;
import lombok.extern.java.Log;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@Log
@ApplicationScoped
public class EventConsumer {

  @Incoming("events")
  public void logEvent(StringEvent event) {
    log.info(String.format("event from kafka: %s", event.toString()));
  }
}
