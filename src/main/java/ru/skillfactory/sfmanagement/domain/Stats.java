package ru.skillfactory.sfmanagement.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "STATS")
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DAY")
    private LocalDate day;

    @Column(name = "STUDENTS")
    private Integer students;

    @Column(name = "ENROLLMENTS")
    private Integer enrollments;

    @Column(name = "COURSES")
    private Integer courses;
}
