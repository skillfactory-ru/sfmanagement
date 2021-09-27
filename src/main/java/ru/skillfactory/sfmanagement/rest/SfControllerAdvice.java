package ru.skillfactory.sfmanagement.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import ru.skillfactory.sfmanagement.rest.exception.StudentNotFound;
import ru.skillfactory.sfmanagement.service.NotificationService;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
@RequiredArgsConstructor
public class SfControllerAdvice {

    private final NotificationService notificationService;

    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<Object> handleStudentNotFoundException(StudentNotFound ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Студент не найден");

        notificationService.notifyAdmin("Возникла исключительная ситуация", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
