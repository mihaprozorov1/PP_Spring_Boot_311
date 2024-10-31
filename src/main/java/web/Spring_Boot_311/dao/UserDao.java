package web.Spring_Boot_311.dao;


import web.Spring_Boot_311.model.User;

import java.util.List;

public interface UserDao {

    List<User> listUsers();

    User getById(int id);

    void save(User user);

    void update(User updatedUser);

    void delete(int id);
}
