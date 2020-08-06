package com.univer.portal.controller.rest;

import com.univer.portal.model.Faculty;
import com.univer.portal.service.faculty.FacultyService;
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
@RequestMapping("/api/admin/faculty")
public class FacultyRestController {
    private final FacultyService facultyService;

    @Autowired
    public FacultyRestController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    /**
     * метод для добавления нового факультета админом
     *
     * @param faculty - факультет которого необходимо добавить
     * @return ResponseEntity, который содержит статус ОК
     */
    @PostMapping("/save")
    public ResponseEntity<?> addFaculty(@RequestBody Faculty faculty) {
        facultyService.addFaculty(faculty);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * метод получения всех факультетов админом
     *
     * @return ResponseEntity, который содержит List факультетов и статус ОК
     */
    @GetMapping("/read")
    public ResponseEntity<List<Faculty>> getAllFaculties() {
        List<Faculty> faculties = facultyService.getAllFaculties();
        return faculties != null && !faculties.isEmpty()
                ? new ResponseEntity<>(faculties, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * метод получения факультета по id админом
     *
     * @return ResponseEntity, который содержит факультета и статус ОК
     */
    @GetMapping("/read{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable long id) {
        Faculty faculty = facultyService.getFacultyById(id);
        return faculty != null
                ? new ResponseEntity<>(faculty, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * метод для обновления факультета админом
     *
     * @param faculty - факультет которого необходимо обновить
     * @return ResponseEntity, который содержит статус ОК
     */
    @PutMapping("/update")
    public ResponseEntity<?> updateFaculty(@RequestBody Faculty faculty) {
        facultyService.updateFaculty(faculty);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * метод для удаления факультета админом
     *
     * @param id - уникальный id факультета которого необходимо удалить
     * @return ResponseEntity, который содержит статус ОК
     */
    @DeleteMapping("/delete{id}")
    public ResponseEntity<?> deleteFaculty(@PathVariable long id) {
        facultyService.deleteFaculty(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
