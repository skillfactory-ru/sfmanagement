package ru.skillfactory.sfmanagement.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Table(name = "ENROLLMENT")
@Entity
public class Enrollment {

    @Id
    private Long id;

    @OneToOne(targetEntity = Course.class)
    private Course course;

    @OneToOne(targetEntity = Student.class)
    private Student student;
}
