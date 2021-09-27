package ru.skillfactory.sfmanagement.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.skillfactory.sfmanagement.domain.Course;
import ru.skillfactory.sfmanagement.service.CourseService;

import javax.validation.Valid;

@RestController
@Api(value = "Контроллер для управления курсами")
@RequestMapping(value = "/api/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @ApiModelProperty(value = "Создать курс")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createCourse(@Valid @RequestBody Course course) {
        courseService.createCourse(course);
    }

    @ApiModelProperty(value = "Обновить курс")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateCourse(@Valid @RequestBody Course course) {
        courseService.updateCourse(course);
    }

    @ApiModelProperty(value = "Получить курс по ID")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Course getCourseById(@PathVariable(name = "id") Long id) {
        return courseService.getById(id);
    }

    @ApiModelProperty(value = "Удалить курс")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") Long id) {
        courseService.deleteCourse(id);
    }


}
