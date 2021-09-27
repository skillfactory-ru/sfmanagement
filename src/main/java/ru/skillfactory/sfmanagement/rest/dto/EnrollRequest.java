package ru.skillfactory.sfmanagement.rest.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import ru.skillfactory.sfmanagement.domain.Course;
import ru.skillfactory.sfmanagement.domain.Student;

@Data
public class EnrollRequest {

    @ApiModelProperty(value = "Студент, желающий записаться на курс")
    private Student student;

    @ApiModelProperty(value = "Курс")
    private Course course;
}
