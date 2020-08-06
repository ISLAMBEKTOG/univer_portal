package com.univer.portal.service.faculty;

import com.univer.portal.dao.FacultyDao;
import com.univer.portal.model.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Реализация интерфейса FacultyService
 *
 * @author Togyzbayev Islambek
 * @version 1.0
 */
@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyDao facultyDao;

    @Autowired
    public FacultyServiceImpl(FacultyDao facultyDao) {
        this.facultyDao = facultyDao;
    }

    /**
     * метод для добавления факультета
     *
     * @param faculty - добавляемая факультет
     * @return void
     */
    @Override
    public void addFaculty(Faculty faculty) {
        facultyDao.save(faculty);
    }

    /**
     * метод для получения списка всех факультетов
     *
     * @return List факультетов
     */
    @Override
    public List<Faculty> getAllFaculties() {
        return facultyDao.findAll();
    }

    /**
     * метод для получения факультета по id
     *
     * @param id - уникальный id факультета
     * @return Faculty - объект представляющий факультет
     */
    @Override
    public Faculty getFacultyById(long id) {
        return facultyDao.findById(id).get();
    }

    /**
     * метод для обновления факультета
     *
     * @param faculty - обновленный топик
     * @return void
     */
    @Override
    public void updateFaculty(Faculty faculty) {
        Faculty facultyFromDB = facultyDao.findById(faculty.getId()).get();
        facultyFromDB.setName(faculty.getName());

        facultyDao.save(facultyFromDB);
    }

    /**
     * метод для удаления факультета по id
     *
     * @param id - уникальный id факультета
     * @return void
     */
    @Override
    public void deleteFaculty(long id) {
        facultyDao.deleteById(id);
    }
}
