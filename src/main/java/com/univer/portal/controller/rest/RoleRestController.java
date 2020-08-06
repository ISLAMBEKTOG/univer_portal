package com.univer.portal.controller.rest;

import com.univer.portal.model.Role;
import com.univer.portal.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Rest контроллер для ролей
 *
 * @author Togyzbayev Islambek
 * @version 1.0
 */
@RestController
@RequestMapping("/api/role")
public class RoleRestController {

    public RoleService roleService;

    @Autowired
    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * метод получения всех ролей
     *
     * @return ResponseEntity, который содержит List ролей
     */
    @GetMapping("/read")
    public ResponseEntity<List<Role>> getAllRoles() {
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }

    /**
     * метод получения роли по ее имени
     *
     * @param name - имя роли
     * @return ResponseEntity, который содержит роль
     */
    @GetMapping("/read{name}")
    public ResponseEntity<Role> getRoleByName(@PathVariable String name) {
        return new ResponseEntity<>(roleService.getRoleByName(name), HttpStatus.OK);
    }

    /**
     * метод для добавления роли
     *
     * @param role - добавлямая роль
     * @return ResponseEntity, который содержит статус OK
     */
    @PostMapping("/save")
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        roleService.addRole(role);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * метод для удаления роли
     *
     * @param id - уникальный id роли
     * @return ResponseEntity, который содержит статус ОК
     */
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeRole(@PathVariable Long id) {
        roleService.removeRole(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
