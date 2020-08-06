package com.univer.portal.controller.rest;

import com.univer.portal.model.User;
import com.univer.portal.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest контроллер для факультетов
 *
 * @author Togyzbayev Islambek
 * @version 1.0
 */
@RestController
@RequestMapping("/api/user")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    /**
     * метод для добавления нового пользователя админом
     *
     * @param user - пользователь которого необходимо добавить
     * @return ResponseEntity, который содержит статус ОК
     */
    @PostMapping("/save")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * метод получения всех пользователей админом
     *
     * @return ResponseEntity, который содержит List пользователей и статус ОК
     */
    @GetMapping("/read")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users != null && !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * метод получения пользователя по id админом
     *
     * @return ResponseEntity, который содержит аользователя и статус ОК
     */
    @GetMapping("/read/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        User user = userService.getUserById(id);
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * метод для обновления пользователя админом
     *
     * @param user - пользовательно которого необходимо обновить
     * @return ResponseEntity, который содержит статус ОК
     */
    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * метод для удаления пользователя админом
     *
     * @param id - уникальный id пользователя которого необходимо удалить
     * @return ResponseEntity, который содержит статус ОК
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
