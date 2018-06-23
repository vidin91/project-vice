package projectvice.dropwizard_app;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import projectvice.dropwizard_app.resource.EventResource;
import projectvice.dropwizard_app.resource.GreeterResource;

/**
 * Hello world!
 *
 */
public class App extends Application<AppConfiguration> {

  @Override
  public void run(AppConfiguration configuration, Environment environment) throws Exception {
    environment.jersey().register(new GreeterResource(configuration));
    environment.jersey().register(new EventResource());
  }
  
  public static void main(String args[]) throws Exception {
    new App().run(args);
  }
  
}
