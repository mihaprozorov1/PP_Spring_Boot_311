package web.Spring_Boot_311.service;


import web.Spring_Boot_311.model.User;

import java.util.List;

public interface UserService {

    List<User> listUsers();

    void save(User user);

    User getById(int id);

    void edit(User user);

    void delete(int id);
}
