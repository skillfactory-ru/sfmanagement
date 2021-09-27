package ru.skillfactory.sfmanagement.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Table(name = "STUDENT")
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME")
    @ApiModelProperty(value = "Имя", example = "Андрей")
    @NotBlank(message = "Обязательное поле")
    private String firstName;

    @Column(name = "LAST_NAME")
    @ApiModelProperty(value = "Отчетство", example = "Иванович")
    @NotBlank(message = "Обязательное поле")
    private String lastName;

    @Column(name = "MIDDLE_NAME")
    @ApiModelProperty(value = "Фамилия", example = "Иванов")
    @NotBlank(message = "Обязательное поле")
    private String middleName;

    @Column(name = "BIRTHDAY")
    @ApiModelProperty(value = "Дата рождения", example = "01.10.1996")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
    private LocalDate birthDay;

    @Column(name = "EMAIL")
    @ApiModelProperty(value = "Электронная почта", example = "ivanov@gmail.com")
    @NotNull(message = "Обязательное поле")
    @NotBlank(message = "Обязательное поле")
    @Email
    private String email;
}
