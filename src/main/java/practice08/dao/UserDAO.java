package practice08.dao;

import practice08.model.User;
import practice08.model.Auto;

import java.util.List;

public interface UserDAO {
    User findById(int id);
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(User user);
    Auto findAutoById(int id);
}
