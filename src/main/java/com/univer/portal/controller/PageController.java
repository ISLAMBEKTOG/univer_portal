package com.univer.portal.controller;

import com.univer.portal.model.Student;
import com.univer.portal.model.User;
import com.univer.portal.service.student.StudentService;
import com.univer.portal.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер возвращающий для показа html страниц
 *
 * @author Togyzbayev Islambek
 * @version 1.0
 */
@Controller
public class PageController {
    private final UserService userService;
    private final StudentService studentService;

    @Autowired
    public PageController(UserService userService, StudentService studentService) {
        this.userService = userService;
        this.studentService = studentService;
    }

    /**
     * метод для страницы логина
     *
     * @return страницу логина
     */
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    /**
     * метод для страницы пользователей
     *
     * @param model - объект для взаимодействия с видом
     * @return страницу пользователя
     */
    @GetMapping("/users")
    public String getUserPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    /**
     * метод для страницы студентов
     *
     * @param model - объект для взаимодействия с видом
     * @return страницу студента
     */
    @GetMapping("/")
    public String getStudentPage(Model model, @AuthenticationPrincipal User user) {
        Student student;
        if (user == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            student = studentService.getStudentByUsername(auth.getName());
        } else {
            student = studentService.getStudentByUsername(user.getUsername());
        }
        model.addAttribute("studentId", student.getId());
        return "student";
    }
}
