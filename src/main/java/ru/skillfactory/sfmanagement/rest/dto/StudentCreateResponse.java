package ru.skillfactory.sfmanagement.rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class StudentCreateResponse extends BaseResponse {

    public BaseResponse errors;
    private Long studentId;

    public StudentCreateResponse(BaseResponse errors) {
        this.errors = errors;
    }
}
