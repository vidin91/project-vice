package projectvice.dropwizard_app;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import projectvice.dropwizard_app.core.CustomConfig;

public class AppConfiguration extends Configuration{
  String messageOnStartup;
  CustomConfig customConfig;
  
  @JsonProperty
  public void setMessageOnStartup(String message) {
    this.messageOnStartup = message;
  }
  
  public void setCustomConfig(CustomConfig config) {
    this.customConfig = config;
  }

  public CustomConfig getCustomConfig() {
    return this.customConfig;
  }
}
