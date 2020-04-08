package com.willredington.api;

import com.willredington.dto.StringEvent;
import com.willredington.entity.CopyItem;
import com.willredington.service.CopyService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import lombok.extern.java.Log;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@Log
@Path("/api")
public class Api {

  private final Emitter<StringEvent> eventEmitter;
  private final CopyService copyService;

  @Inject
  public Api(@Channel("events") Emitter<StringEvent> eventEmitter, CopyService copyService) {
    this.eventEmitter = eventEmitter;
    this.copyService = copyService;
  }

  @POST
  @Path("copy")
  public void copy(StringEvent event) {
    eventEmitter.send(event);
    copyService.save(event);
  }

  @GET
  @Path("all")
  public List<CopyItem> getAll() {
    return copyService.getAll();
  }
}
