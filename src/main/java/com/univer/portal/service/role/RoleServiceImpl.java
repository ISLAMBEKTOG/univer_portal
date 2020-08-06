package com.univer.portal.service.role;

import com.univer.portal.dao.RoleDao;
import com.univer.portal.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Реализация интерфейса RoleService
 *
 * @author Togyzbayev Islambek
 * @version 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    /**
     * метод для добавления роли
     *
     * @param role - добавляемая роль
     * @return boolean - удалось добавить роль или нет
     */
    @Transactional
    @Override
    public void addRole(Role role) {
        roleDao.save(role);
    }

    /**
     * метод для получения роли по id
     *
     * @param id - уникальный id роли
     * @return Role - объект представляющий роль пользователей
     */
    @Transactional(readOnly = true)
    @Override
    public Role getRoleById(Long id) {
        return roleDao.findById(id).get();
    }

    /**
     * метод для получения роли по названию
     *
     * @param name - название роли
     * @return Role - объект представляющий роль пользователей
     */
    @Transactional(readOnly = true)
    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    /**
     * метод для удаления роли по id
     *
     * @param id - уникальный id роли
     * @return void
     */
    @Transactional
    @Override
    public void removeRole(Long id) {
        roleDao.deleteById(id);
    }

    /**
     * метод для получения списка всех ролей
     *
     * @return List ролей
     */
    @Transactional
    @Override
    public List<Role> getAllRoles() {
        return roleDao.findAll();
    }
}
