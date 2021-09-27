package ru.skillfactory.sfmanagement.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.skillfactory.sfmanagement.dao.StudentRepository;
import ru.skillfactory.sfmanagement.domain.Student;
import ru.skillfactory.sfmanagement.metrics.CounterService;
import ru.skillfactory.sfmanagement.rest.dto.BaseResponse;
import ru.skillfactory.sfmanagement.rest.dto.StudentCreateResponse;
import ru.skillfactory.sfmanagement.rest.dto.StudentUpdateResponse;
import ru.skillfactory.sfmanagement.rest.exception.StudentNotFound;

import javax.management.Notification;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;
    private final NotificationService notificationService;
    private final CounterService counterService;

    public BaseResponse createStudent(Student student) {
        log.info("Сохраняем студента {}", student);
        Student savedStudent = studentRepository.save(student);
        log.info("Студент сохранен {}", student);
        notificationService.notifyAdmin("Создан новый студент", student.toString());
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setErrorMessage("Успешно");
        baseResponse.setErrorCode(0L);
        StudentCreateResponse studentCreateResponse = new StudentCreateResponse(baseResponse);
        studentCreateResponse.setStudentId(savedStudent.getId());
        counterService.increaseCount("students.created", LocalDate.now().toString(), String.valueOf(studentRepository.findAll().size()));
        return studentCreateResponse;
    }

    public BaseResponse updateStudent(Student student) {
        log.info("Студент до обновления {}", student);
        if (this.getStudentById(student.getId()) == null) {
            log.info("Студент с ID = {} не найден в базе данных", student.getId());
            throw new StudentNotFound();
        }
        Student updatedStudent = studentRepository.save(student);
        log.info("Студент обновлен {}", student);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setErrorCode(0L);
        baseResponse.setErrorMessage("Успешно");
        StudentUpdateResponse response = new StudentUpdateResponse(baseResponse);
        response.setStudent(updatedStudent);
        notificationService.notifyAdmin("Обновление студента", student.toString());
        return response;
    }

    public Student getStudentById(Long id) {
        log.info("Получаем студента с ID = {} из базы", id);
        return studentRepository.findById(id).get();
    }

    public void deleteStudent(Long id) {
        log.info("Удаляем студента с ID = {} из базы", id);
        studentRepository.deleteById(id);
    }
}
