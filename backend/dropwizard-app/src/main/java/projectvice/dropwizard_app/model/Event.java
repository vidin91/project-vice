package projectvice.dropwizard_app.model;

import java.util.List;

public class Event {
  private String title;
  private String description;
  private long date;
  List<String> organizers;
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public long getDate() {
    return date;
  }
  public void setDate(long date) {
    this.date = date;
  }
  public List<String> getOrganizers() {
    return organizers;
  }
  public void setOrganizers(List<String> organizers) {
    this.organizers = organizers;
  }
  
  public String toString() {
    return "Event: " + this.title + " (" + this.description + ")";
  }
}
