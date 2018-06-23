package projectvice.user_service.service;

import java.sql.Connection;

public interface DBConnectionService {
  Connection getConnection();
  void releaseConnection(Connection con);
}
