package com.yuen.springInterceptor.pojo;

import lombok.Builder;

@Builder
public class ApiResponse {
    private Integer code;
    private String status;
    private String message;
}
