package com.willredington.serde;

import com.willredington.dto.StringEvent;
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class StringEventSerializer extends ObjectMapperDeserializer<StringEvent> {

  public StringEventSerializer() {
    super(StringEvent.class);
  }
}
