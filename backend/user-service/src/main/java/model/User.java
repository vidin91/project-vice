package model;

import java.util.Date;

public class User {
  private long id;
  private String name;
  private String lastname;
  private String username;
  private Date born;
  private boolean enabled;
  private Date registered;
  private String password;
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getLastname() {
    return lastname;
  }
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }
  
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public boolean isEnabled() {
    return enabled;
  }
  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }
  public Date getBorn() {
    return born;
  }
  public void setBorn(Date born) {
    this.born = born;
  }
  public Date getRegistered() {
    return registered;
  }
  public void setRegistered(Date registered) {
    this.registered = registered;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
}
