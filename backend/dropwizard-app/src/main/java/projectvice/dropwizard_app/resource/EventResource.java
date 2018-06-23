package projectvice.dropwizard_app.resource;

import java.util.Arrays;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import projectvice.dropwizard_app.model.Event;

@Path("/api/events")
@Produces(MediaType.APPLICATION_JSON)
public class EventResource {

  @GET
  public Event getEvent() {
    Event e = new Event();
    e.setTitle("SERBIA - ITALY football game");
    e.setDescription("first match on FIFA world cup");
    e.setDate(System.currentTimeMillis());
    e.setOrganizers(Arrays.asList("Organizer1", "Organizer2"));
    return e;
  }
}
