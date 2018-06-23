package projectvice.user_service.service;

public interface LoginService {
  long login(String username, String password);
  boolean validateToken(String token);
}
