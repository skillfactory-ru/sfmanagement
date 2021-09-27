package ru.skillfactory.sfmanagement.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.skillfactory.sfmanagement.dao.CourseRepository;
import ru.skillfactory.sfmanagement.domain.Course;
import ru.skillfactory.sfmanagement.metrics.CounterService;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService {

    private final CourseRepository courseRepository;
    private final CounterService counterService;

    public void createCourse(Course course) {
        log.info("Создаем курс = {}", course);
        Course savedCourse = courseRepository.save(course);
        log.info("Курс успешно сохранен = {}", savedCourse);
        counterService.increaseCount("course.created", LocalDate.now().toString(), String.valueOf(courseRepository.findAll().size()));
    }

    public void updateCourse(Course course) {
        log.info("Начинаем обновлять курс = {}", course);
        courseRepository.save(course);
        log.info("Курс успешно обновлен = {}", course);
    }

    public Course getById(Long id) {
        log.info("Пытаемся получать курс с идентификатором = {}", id);
        return courseRepository.findById(id).get();
    }

    public void deleteCourse(Long id) {
        log.info("Удаляем курс с идентификатором = {}", id);
        courseRepository.deleteById(id);
    }
}
