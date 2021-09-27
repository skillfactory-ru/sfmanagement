package ru.skillfactory.sfmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skillfactory.sfmanagement.domain.Student;

@Repository
public interface StudentDao extends JpaRepository<Long, Student> {
}
