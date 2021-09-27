package ru.skillfactory.sfmanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skillfactory.sfmanagement.dao.StudentDao;
import ru.skillfactory.sfmanagement.domain.Student;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentDao studentDao;

    public void createStudent() {

    }

    public void updateStudent() {

    }

    public void getStudentById(Long id) {

    }

    public void deleteStudent(Long id) {

    }

    public void deleteStudent(Student student) {

    }
}
