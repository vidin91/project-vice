package projectvice.user_service.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projectvice.user_service.service.DBConnectionService;

public class DBConnectionServiceImpl implements DBConnectionService {
  private static DBConnectionServiceImpl service;
  public static DBConnectionService getInstance() {
    if (service == null) {
      service = new DBConnectionServiceImpl();
    }
    return service;
  }
  
  private static int DEFAULT_BUFFER_SIZE = 10;
  
  private Connection [] buffer;
  private int head = 0, tail = 0, size = 0;

  private DBConnectionServiceImpl() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      buffer = new Connection[DEFAULT_BUFFER_SIZE];
      for (int i = 0; i < buffer.length; i++) {
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectvice", "root", "sifra123");
        buffer[i] = c;
      }
      this.tail = this.buffer.length - 1;
      this.size = this.buffer.length;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }

  public Connection getConnection() {
      try {
        while (this.size <= 0) {
          wait();
        }
        Connection c = this.buffer[head];
        head = (head + 1) % this.buffer.length;
        size--;
        return c;
      } catch (InterruptedException e) {
      }
    return null;
  }

  public void releaseConnection(Connection con) {
    this.buffer[tail] = con;
    tail = (tail + 1) % this.buffer.length;
    size++;
    // notifyAll();
  }
}
