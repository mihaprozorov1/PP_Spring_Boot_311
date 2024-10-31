package web.Spring_Boot_311.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.Spring_Boot_311.dao.UserDao;
import web.Spring_Boot_311.model.User;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Transactional
    @Override
    public void edit(User user) {
        userDao.update(user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
