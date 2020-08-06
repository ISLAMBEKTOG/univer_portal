package com.univer.portal.service.student;

import com.univer.portal.dao.StudentDao;
import com.univer.portal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Реализация интерфейса StudentService
 *
 * @author Togyzbayev Islambek
 * @version 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    /**
     * метод для добавления студента
     *
     * @param student - добавляемая студент
     * @return void
     */
    @Override
    public void addStudent(Student student) {
        studentDao.save(student);
    }

    /**
     * метод для получения списка всех студентов
     *
     * @return List студентов
     */
    @Override
    public List<Student> allStudents() {
        return studentDao.findAll();
    }

    /**
     * метод для получения студента по id
     *
     * @param id - уникальный id студента
     * @return Student - объект представляющий студент
     */
    @Override
    public Student getStudentById(long id) {
        return studentDao.findById(id).get();
    }

    /**
     * метод для получения студента по username
     *
     * @param username - имя студента
     * @return Student - объект представляющий студент
     */
    @Override
    public Student getStudentByUsername(String username) {
        return studentDao.getStudentByUsername(username);
    }

    /**
     * метод для обновления студента
     *
     * @param student - обновленный студент
     * @return void
     */
    @Override
    public void updateStudent(Student student) {
        Student studentFromDb = studentDao.getOne(student.getId());
        studentFromDb.setFirstName(student.getFirstName());
        studentFromDb.setLastName(student.getLastName());
        studentFromDb.setBirthDate(student.getBirthDate());
        studentFromDb.setEntBall(student.getEntBall());
        studentFromDb.setEmail(student.getEmail());

        studentDao.save(studentFromDb);
    }

    /**
     * метод для удаления студента по id
     *
     * @param id - уникальный id студента
     * @return void
     */
    @Override
    public void deleteStudent(long id) {
        studentDao.deleteById(id);
    }
}
