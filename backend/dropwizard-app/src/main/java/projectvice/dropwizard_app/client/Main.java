/**
 * Example using Jersey Client
 * (for Apache HttpClient see examples project)
 */

package projectvice.dropwizard_app.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import projectvice.dropwizard_app.model.Event;

public class Main {
  public static void main(String[] args) {
    Client client = ClientBuilder.newClient();
    Event e = client
              .target("http://localhost:8080/api/events")
              .request(MediaType.APPLICATION_JSON)
              .get(Event.class);
    System.out.println(e);
  }
}
