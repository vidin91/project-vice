package projectvice.user_service.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.User;
import projectvice.user_service.service.DBConnectionService;
import projectvice.user_service.service.UserService;

public class UserServiceImpl implements UserService {
  private static UserService service;
  public static UserService getInstance() {
    if (service == null)  {
      service = new UserServiceImpl();
    }
    return service;
  }
  
  private UserServiceImpl() {}
  public List<User> getUsers() {
    // TODO Auto-generated method stub
    return null;
  }

  public User getUser(long id) {
    DBConnectionService dbService = DBConnectionServiceImpl.getInstance();
    Connection c = dbService.getConnection();
    try {
      Statement st = c.createStatement();
      /*
       * try sql injection!
       */
      ResultSet rs = st.executeQuery("select * from users where id = '" + id  + "'");
      if (rs.next()) {
        return this.mapFromRS(rs);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DBConnectionServiceImpl.getInstance().releaseConnection(c);
    }
    return null;
  }

  public User addUser(User u) {
    // TODO Auto-generated method stub
    return null;
  }

  public User updateUser(User u) {
    // TODO Auto-generated method stub
    return null;
  }

  public boolean deleteUser(long id) {
    // TODO Auto-generated method stub
    return false;
  }

  public User getUser(String username) {
    DBConnectionService dbService = DBConnectionServiceImpl.getInstance();
    Connection c = dbService.getConnection();
    try {
      Statement st = c.createStatement();
      /*
       * try sql injection!
       */
      ResultSet rs = st.executeQuery("select * from users where username = '" + username  + "'");
      if (rs.next()) {
        return this.mapFromRS(rs);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DBConnectionServiceImpl.getInstance().releaseConnection(c);
    }
    return null;
  }
  
  private User mapFromRS(ResultSet rs) throws SQLException {
    User u = new User();
    u.setId(rs.getLong(1));
    u.setName(rs.getString(2));
    u.setLastname(rs.getString(3));
    u.setUsername(rs.getString(4));
    u.setBorn(rs.getDate(5));
    u.setEnabled(rs.getBoolean(6));
    u.setRegistered(rs.getDate(7));
    u.setPassword(rs.getString(8));
    return u;
  }

}
