package com.univer.portal.service.role;


import com.univer.portal.model.Role;

import java.util.List;

/**
 * Интерфейс для работы с ролями пользователей
 *
 * @author Togyzbayev Islambek
 * @version 1.0
 */
public interface RoleService {
    /**
     * метод для добавления роли
     *
     * @param role - добавляемая роль
     * @return void
     */
    void addRole(Role role);

    /**
     * метод для получения списка всех ролей
     *
     * @return List ролей
     */
    List<Role> getAllRoles();

    /**
     * метод для получения роли по id
     *
     * @param id - уникальный id роли
     * @return Role - объект представляющий роль пользователей
     */
    Role getRoleById(Long id);

    /**
     * метод для получения роли по названию
     *
     * @param name - название роли
     * @return Role - объект представляющий роль пользователей
     */
    Role getRoleByName(String name);

    /**
     * метод для удаления роли по id
     *
     * @param id - уникальный id роли
     * @return void
     */
    void removeRole(Long id);
}
