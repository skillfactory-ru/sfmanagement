package ru.skillfactory.sfmanagement.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.skillfactory.sfmanagement.rest.dto.EnrollRequest;
import ru.skillfactory.sfmanagement.service.EnrollmentService;

import javax.validation.Valid;

@RestController
@Api(value = "REST контроллер для управления подписками на курсы")
@RequestMapping(value = "/api/enroll")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @ApiOperation(value = "Подписать студента на курс")
    @RequestMapping(value = "/enroll", method = RequestMethod.POST)
    public void enroll(@Valid @RequestBody EnrollRequest enrollRequest) {
        enrollmentService.enroll(enrollRequest.getStudent(), enrollRequest.getCourse());
    }

    @ApiOperation(value = "Отписать студента от курса")
    @RequestMapping(value = "/leave", method = RequestMethod.POST)
    public void leave(@Valid @RequestBody EnrollRequest enrollRequest) {
        enrollmentService.leave(enrollRequest.getStudent(), enrollRequest.getCourse());
    }


}
