package ru.skillfactory.sfmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skillfactory.sfmanagement.domain.Course;
import ru.skillfactory.sfmanagement.domain.Enrollment;
import ru.skillfactory.sfmanagement.domain.Student;

import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    Optional<Enrollment> findByCourseAndStudent(Course course, Student student);
}
