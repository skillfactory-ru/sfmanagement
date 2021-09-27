package ru.skillfactory.sfmanagement.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final JavaMailSender javaMailSender;

    @Value("${app.admin.email}")
    private String adminEmail;

    @Value("${app.admin.notification.enabled}")
    private boolean notificationEnabled;

    public void notifyStudent(String studentEmail, String subject, String text) {
        if (notificationEnabled) {
            log.info("Отправка сообщения на email = {}. Тема письма: {}, текст письма: {}", studentEmail, subject, text);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("sfmgmt@sf.ru");
            message.setTo(studentEmail);
            message.setSubject(subject);
            message.setText(text);
            javaMailSender.send(message);
            log.info("Письмо на email = {} успешно отправлено", studentEmail);
        } else {
            log.info("Нотификации отключены...");
        }
    }

    public void notifyAdmin(String subject, String text) {
        if (notificationEnabled) {
            log.info("Отправка сообщения на email = {}. Тема письма: {}, текст письма: {}", adminEmail, subject, text);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("sfmgmt@sf.ru");
            message.setTo(adminEmail);
            message.setSubject(subject);
            message.setText(text);
            javaMailSender.send(message);
            log.info("Письмо на email = {} успешно отправлено", adminEmail);
        } else {
            log.info("Нотификации отключены...");
        }
    }
}
