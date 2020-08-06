package com.univer.portal.dao;

import com.univer.portal.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс для доступа к студентам из базы
 *
 * @author Togyzbayev Islambek
 * @version 1.0
 */
public interface StudentDao extends JpaRepository<Student, Long> {
    Student getStudentByUsername(String username);
}
