package projectvice.user_service.service;

import java.util.List;

import model.User;

public interface UserService {
  List<User> getUsers();
  User getUser(long id);
  User getUser(String username);
  User addUser(User u);
  User updateUser(User u);
  boolean deleteUser(long id);
}
