package ru.skillfactory.sfmanagement.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Table(name = "STUDENTS")
public class Student {

    @Id
    private Long id;

    @ApiModelProperty(value = "Имя", example = "Андрей")
    @NotBlank(message = "Обязательное поле")
    private String firstName;

    @ApiModelProperty(value = "Отчетство", example = "Иванович")
    @NotBlank(message = "Обязательное поле")
    private String lastName;

    @ApiModelProperty(value = "Фамилия", example = "Иванов")
    @NotBlank(message = "Обязательное поле")
    private String middleName;

    @ApiModelProperty(value = "Дата рождения", example = "01.10.1996")
    @NotBlank(message = "Обязательное поле")
    private LocalDate birthDay;
}
