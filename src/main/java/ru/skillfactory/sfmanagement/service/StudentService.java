package ru.skillfactory.sfmanagement.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.skillfactory.sfmanagement.dao.StudentRepository;
import ru.skillfactory.sfmanagement.domain.Student;
import ru.skillfactory.sfmanagement.rest.dto.BaseResponse;
import ru.skillfactory.sfmanagement.rest.dto.StudentCreateResponse;
import ru.skillfactory.sfmanagement.rest.dto.StudentUpdateResponse;
import ru.skillfactory.sfmanagement.rest.exception.StudentNotFound;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;

    public BaseResponse createStudent(Student student) {
        log.info("Сохраняем студента {}", student);
        Student savedStudent = studentRepository.save(student);
        log.info("Студент сохранен {}", student);
        return StudentCreateResponse.builder().studentId(savedStudent.getId()).build();
    }

    public BaseResponse updateStudent(Student student) {
        log.info("Студент до обновления {}", student);
        if (this.getStudentById(student.getId()) == null) {
            log.info("Студент с ID = {} не найден в базе данных", student.getId());
            throw new StudentNotFound();
        }
        Student updatedStudent = studentRepository.save(student);
        log.info("Студент обновлен {}", student);
        StudentUpdateResponse response = new StudentUpdateResponse(BaseResponse.builder().errorMessage("Успешно").errorCode(0L).build());
        response.setStudent(updatedStudent);
        return response;
    }

    public Student getStudentById(Long id) {
        return null;
    }

    public void deleteStudent(Long id) {

    }

    public void deleteStudent(Student student) {

    }
}
