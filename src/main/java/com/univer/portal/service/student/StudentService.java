package com.univer.portal.service.student;

import com.univer.portal.model.Student;

import java.util.List;

/**
 * Интерфейс для работы с студентами
 *
 * @author Togyzbayev Islambek
 * @version 1.0
 */
public interface StudentService {
    /**
     * метод для добавления студента
     *
     * @param student - добавляемая студент
     * @return void
     */
    void addStudent(Student student);

    /**
     * метод для получения списка всех студентов
     *
     * @return List студентов
     */
    List<Student> allStudents();

    /**
     * метод для получения студента по id
     *
     * @param id - уникальный id студента
     * @return Student - объект представляющий студент
     */
    Student getStudentById(long id);

    /**
     * метод для получения студента по username
     *
     * @param username - имя студента
     * @return Student - объект представляющий студент
     */
    Student getStudentByUsername(String username);

    /**
     * метод для обновления студента
     *
     * @param student - обновленный студент
     * @return void
     */
    void updateStudent(Student student);

    /**
     * метод для удаления студента по id
     *
     * @param id - уникальный id студента
     * @return void
     */
    void deleteStudent(long id);
}
