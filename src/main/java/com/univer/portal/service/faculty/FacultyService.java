package com.univer.portal.service.faculty;

import com.univer.portal.model.Faculty;

import java.util.List;

/**
 * Интерфейс для работы с факультетами
 *
 * @author Togyzbayev Islambek
 * @version 1.0
 */
public interface FacultyService {
    /**
     * метод для добавления факультета
     *
     * @param faculty - добавляемая факультет
     * @return void
     */
    void addFaculty(Faculty faculty);

    /**
     * метод для получения списка всех факультетов
     *
     * @return List факультетов
     */
    List<Faculty> getAllFaculties();

    /**
     * метод для получения факультета по id
     *
     * @param id - уникальный id факультета
     * @return Faculty - объект представляющий факультет
     */
    Faculty getFacultyById(long id);

    /**
     * метод для обновления факультета
     *
     * @param faculty - обновленный топик
     * @return void
     */
    void updateFaculty(Faculty faculty);

    /**
     * метод для удаления факультета по id
     *
     * @param id - уникальный id факультета
     * @return void
     */
    void deleteFaculty(long id);
}
