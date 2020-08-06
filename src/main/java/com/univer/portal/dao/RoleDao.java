package com.univer.portal.dao;

import com.univer.portal.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс для доступа к пользовательским ролям из базы
 *
 * @author Togyzbayev Islambek
 * @version 1.0
 */
public interface RoleDao extends JpaRepository<Role, Long> {
    Role getRoleByName(String name);
}
