package com.grevicoc.technicalgli.outbounds.models.response;

import lombok.Data;

@Data
public class BaseResponse<T> {
    String status;
    T message;
}
