package practice08.services;

import practice08.dao.UserDAO;
import practice08.dao.UserDAOImpl;
import practice08.model.Auto;
import practice08.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    public UserServiceImpl() {}

    @Override
    public User findUser(int id) {
        return userDAO.findById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userDAO.findAll();
    }

    @Override
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.update(user);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.delete(user);
    }

    @Override

    public Auto findAutoById(int id) {
        return userDAO.findAutoById(id);
    }
}
