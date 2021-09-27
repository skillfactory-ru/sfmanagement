package ru.skillfactory.sfmanagement.rest.dto;

import lombok.Data;

@Data
public class BaseResponse {
    private String errorMessage;
    private String errorCode;
}
