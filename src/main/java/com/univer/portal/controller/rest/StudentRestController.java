package com.univer.portal.controller.rest;

import com.univer.portal.model.Student;
import com.univer.portal.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest контроллер для студентов
 *
 * @author Togyzbayev Islambek
 * @version 1.0
 */
@RestController
@RequestMapping("/api/student")
public class StudentRestController {
    private final StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * метод для добавления нового студента админом
     *
     * @param student - студент которого необходимо добавить
     * @return ResponseEntity, который содержит статус ОК
     */
    @PostMapping("/save")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * метод получения всех студентов админом
     *
     * @return ResponseEntity, который содержит List студентов и статус ОК
     */
    @GetMapping("/read")
    public ResponseEntity<List<Student>> allStudents() {
        List<Student> students = studentService.allStudents();
        return students != null && !students.isEmpty()
                ? new ResponseEntity<>(students, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * метод получения студента по id админом
     *
     * @return ResponseEntity, который содержит студента и статус ОК
     */
    @GetMapping("/read/{id}")
    public ResponseEntity<Student> readStudent(@PathVariable long id) {
        Student student = studentService.getStudentById(id);
        return student != null
                ? new ResponseEntity<>(student, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * метод для обновления студента админом
     *
     * @param student - студент которого необходимо обновить
     * @return ResponseEntity, который содержит статус ОК
     */
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Student student) {
        studentService.updateStudent(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * метод для удаления студента админом
     *
     * @param id - уникальный id студента которого необходимо удалить
     * @return ResponseEntity, который содержит статус ОК
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
