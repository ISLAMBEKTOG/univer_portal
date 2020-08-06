package com.univer.portal.dao;

import com.univer.portal.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс для доступа к факультетам из базы
 *
 * @author Togyzbayev Islambek
 * @version 1.0
 */
public interface FacultyDao extends JpaRepository<Faculty, Long> {
}
