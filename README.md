# SkillFactory Student Management System

**Проект для вебинара**


## Назначение данного сервиса
* Управление учетными записями студентов
* Нотификация студентов по определенному времени

## Данный проект использует следующие технологии
* Java 11 - основной язык приложения
* Spring Boot 2 - основной фреймворк
* Maven - система сборки
* Liqubase - система управления миграции
* Java Mail Sender - библиотека отправки Email
* Influx - NoSQL база данных
* PostgreSQL - SQL база данных
* Quartz - распределенный планировщик задач
* Docker - для контейнеризации приложения

## Архитектура проекта
Проект имеет трехзвенную архитектуру, которая выглядит следующим 
образом:
REST(контроллеры) -> Сервисы -> Уровень доступа к базе данных
