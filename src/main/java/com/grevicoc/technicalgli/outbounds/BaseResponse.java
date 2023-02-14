package com.grevicoc.technicalgli.outbounds;

import lombok.Data;

@Data
public class BaseResponse<T> {
    String status;
    T message;
}
