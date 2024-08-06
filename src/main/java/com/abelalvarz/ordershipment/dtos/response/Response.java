package com.abelalvarz.ordershipment.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private int statusCode;
    private boolean success;
    private String message;
    private Object data;
}
