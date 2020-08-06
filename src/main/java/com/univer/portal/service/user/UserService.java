package com.univer.portal.service.user;

import com.univer.portal.model.User;

import java.util.List;

/**
 * Интерфейс для работы с пользователями
 *
 * @author Togyzbayev Islambek
 * @version 1.0
 */
public interface UserService {
    /**
     * метод для добавления пользователя
     *
     * @param user - пользователь которого необходимо добавить
     * @return void
     */
    void addUser(User user);

    /**
     * метод для получения всего списка пользователей
     *
     * @return List пользоватей
     */
    List<User> getAllUsers();

    /**
     * метод для получения пользователя по уникальному id
     *
     * @param id - уникальный id пользователя
     * @return User - пользователь
     */
    User getUserById(long id);

    /**
     * метод для обновления пользовательских данных
     *
     * @param user - пользователь с обновленными данными
     * @return boolean - удалось обновить данные или нет
     */
    void updateUser(User user);

    /**
     * метод для удаления пользователя
     *
     * @param id - уникальный id пользователя в системе
     */
    void deleteUser(long id);
}
