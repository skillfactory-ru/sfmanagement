package ru.skillfactory.sfmanagement.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.skillfactory.sfmanagement.rest.dto.BaseResponse;
import ru.skillfactory.sfmanagement.service.StudentService;

@RestController
@Api(value = "REST контроллер для управления студентами")
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/api/student")
public class StudentController {

    private final StudentService studentService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiOperation(value = "Создание нового студента")
    public BaseResponse createStudent() {
        return null;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ApiOperation(value = "Обновление студента")
    public BaseResponse updateStudent() {
        return null;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Получение студента по ID")
    public BaseResponse getStudent(@PathVariable(value = "id") Long id) {
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public BaseResponse deleteStudent(@PathVariable(value = "id") Long id) {
        return null;
    }


}
