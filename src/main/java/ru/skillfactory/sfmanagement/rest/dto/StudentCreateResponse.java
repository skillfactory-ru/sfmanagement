package ru.skillfactory.sfmanagement.rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentCreateResponse extends BaseResponse {
    private boolean studentId;
}