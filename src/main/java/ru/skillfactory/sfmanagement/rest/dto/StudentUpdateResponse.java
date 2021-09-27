package ru.skillfactory.sfmanagement.rest.dto;

import lombok.Builder;
import lombok.Data;
import ru.skillfactory.sfmanagement.domain.Student;

@Data
public class StudentUpdateResponse extends BaseResponse {

    private BaseResponse errors;
    public Student student;

    public StudentUpdateResponse(BaseResponse errors) {
        super();
        this.errors = errors;
    }
}
