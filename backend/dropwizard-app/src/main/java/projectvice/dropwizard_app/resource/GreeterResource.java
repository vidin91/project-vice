package projectvice.dropwizard_app.resource;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import io.dropwizard.Configuration;
import projectvice.dropwizard_app.AppConfiguration;
import projectvice.dropwizard_app.core.CustomConfig;

@Path("/api/greeter")
@Produces(MediaType.APPLICATION_JSON)
public class GreeterResource {
  private final AppConfiguration config;
  
  public GreeterResource(AppConfiguration config) {
    this.config = config;
  }
  
  @GET
  @Path("/info")
  public CustomConfig getInfo() {
    return config.getCustomConfig();
  }
  
  @GET
  public String String() {
    return "HELLO WORLD";
  }
  
  @GET
  @Path("/{user}")
  public String sayHelloToUser(@PathParam("user") String user,
                               @QueryParam("message") @NotNull String message) {
    return String.format("Hey , %s! %s", user, message);
  }
}
