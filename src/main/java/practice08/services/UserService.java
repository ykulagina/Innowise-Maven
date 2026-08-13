package practice08.services;

import practice08.model.Auto;
import practice08.model.User;

import java.util.List;

public interface UserService {
    User findUser(int id);
    List<User> findAllUsers();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    Auto findAutoById(int id);
}
