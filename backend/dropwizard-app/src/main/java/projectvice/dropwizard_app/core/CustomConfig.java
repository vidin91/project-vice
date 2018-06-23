package projectvice.dropwizard_app.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomConfig {
  @JsonProperty
  private long seedParam;
  
  @JsonProperty
  private String message;

  public long getSeedParam() {
    return seedParam;
  }
  public void setSeedParam(long seedParam) {
    this.seedParam = seedParam;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  
}
