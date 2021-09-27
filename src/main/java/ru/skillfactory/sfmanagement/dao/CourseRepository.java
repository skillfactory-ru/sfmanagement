package ru.skillfactory.sfmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skillfactory.sfmanagement.domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
