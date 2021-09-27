package ru.skillfactory.sfmanagement.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.skillfactory.sfmanagement.domain.Student;
import ru.skillfactory.sfmanagement.rest.dto.BaseResponse;
import ru.skillfactory.sfmanagement.service.StudentService;

import javax.validation.Valid;

@RestController
@Api(value = "REST контроллер для управления студентами")
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/api/student")
public class StudentController {

    private final StudentService studentService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiOperation(value = "Создание нового студента")
    public BaseResponse createStudent(@Valid @RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ApiOperation(value = "Обновление студента")
    public BaseResponse updateStudent(@Valid @RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Получение студента по ID")
    public Student getStudent(@PathVariable(value = "id") Long id) {
        return studentService.getStudentById(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Удаление студента по ID")
    public void delete(@PathVariable(value = "id") Long id) {
        studentService.deleteStudent(id);
    }
}
