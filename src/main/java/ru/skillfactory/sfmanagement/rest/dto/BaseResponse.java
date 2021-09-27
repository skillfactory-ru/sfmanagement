package ru.skillfactory.sfmanagement.rest.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class BaseResponse {
    private String errorMessage;
    private Long errorCode;
}
