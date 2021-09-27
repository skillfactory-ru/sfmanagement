package ru.skillfactory.sfmanagement.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.skillfactory.sfmanagement.dao.EnrollmentRepository;
import ru.skillfactory.sfmanagement.domain.Course;
import ru.skillfactory.sfmanagement.domain.Enrollment;
import ru.skillfactory.sfmanagement.domain.Student;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final NotificationService notificationService;


    public void enroll(Student student, Course course) {
        log.info("Записываем студента = {} на курс = {}", student, course);
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        notificationService.notifyStudent(student.getEmail(), "Успешная регистрация на курс", "Поздравляем с успешной регистрацией на ркусе");
        log.info("Запись студента = {} завершена", student);
    }

    public void leave(Student student, Course course) {
        log.info("Пытаемся найти запись студента = {} на курс = {}", student, course);
        Optional<Enrollment> enrollment = enrollmentRepository.findByCourseAndStudent(course, student);
        if (enrollment.isPresent()) {
            log.info("Запись найдена, идентификатор = {}", enrollment.get().getId());
            enrollmentRepository.delete(enrollment.get());
            log.info("Запись успешно удалена");
        } else {
            log.info("Запись студента = {} на курс = {} не найдена", student, course);
        }
    }
}
