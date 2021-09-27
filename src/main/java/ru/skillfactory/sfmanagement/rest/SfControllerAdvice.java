package ru.skillfactory.sfmanagement.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import ru.skillfactory.sfmanagement.rest.exception.StudentNotFound;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class SfControllerAdvice {

    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<Object> handleStudentNotFoundException(StudentNotFound ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Студент не найден");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
