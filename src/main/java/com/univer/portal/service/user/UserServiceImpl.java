package com.univer.portal.service.user;

import com.univer.portal.dao.UserDao;
import com.univer.portal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Реализация интерфейса UserService
 *
 * @author Togyzbayev Islambek
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * метод для добавления пользователя
     *
     * @param user - пользователь которого необходимо добавить
     * @return void
     */
    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    /**
     * метод для получения всего списка пользователей
     *
     * @return List пользоватей
     */
    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    /**
     * метод для получения пользователя по уникальному id
     *
     * @param id - уникальный id пользователя
     * @return User - пользователь
     */
    @Override
    public User getUserById(long id) {
        return userDao.findById(id).get();
    }

    /**
     * метод для обновления пользовательских данных
     *
     * @param user - пользователь с обновленными данными
     * @return boolean - удалось обновить данные или нет
     */
    @Override
    public void updateUser(User user) {
        User userFromDB = userDao.findById(user.getId()).get();
        userFromDB.setPassword(user.getPassword());

        userDao.save(userFromDB);
    }

    /**
     * метод для удаления пользователя
     *
     * @param id - уникальный id пользователя в системе
     */
    @Override
    public void deleteUser(long id) {
        userDao.deleteById(id);
    }
}
