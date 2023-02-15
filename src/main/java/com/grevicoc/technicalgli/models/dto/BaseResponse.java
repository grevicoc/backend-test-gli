package com.grevicoc.technicalgli.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponse<T> {
    private int code;
    private String message;
    private T data;
    private String status;
}
