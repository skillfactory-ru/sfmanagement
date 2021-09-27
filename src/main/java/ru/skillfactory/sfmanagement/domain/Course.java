package ru.skillfactory.sfmanagement.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Table(name = "COURSE")
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    @ApiModelProperty(value = "Название курса", example = "Программирование на Java")
    @NotNull(message = "Обязательное поле")
    @NotBlank(message = "Обязательное поле")
    private String title;

    @Column(name = "DESCRIPTION")
    @ApiModelProperty(value = "Описание курса", example = "В данном курсе будет рассказано о разработке бэкенда на Java")
    @NotNull(message = "Обязательное поле")
    @NotBlank(message = "Обязательное поле")
    private String description;

    @Column(name = "DURATION")
    @ApiModelProperty(value = "Продолжительность курса в днях", example = "60")
    @NotNull(message = "Обязательное поле")
    private Integer duration;

    @Column(name = "START_DATE")
    @ApiModelProperty(value = "Дата начала занятий", example = "2021-10-01")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
    private LocalDate startDate;

    @Column(name = "FINISH_DATE")
    @ApiModelProperty(value = "Дата окончания занятий", example = "2021-12-31")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
    private LocalDate finishDate;
}
