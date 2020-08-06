package com.univer.portal.dao;

import com.univer.portal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс для доступа к пользователям из базы
 *
 * @author Togyzbayev Islambek
 * @version 1.0
 */
public interface UserDao extends JpaRepository<User, Long> {
    User getUserByUsername(String userName);
}
