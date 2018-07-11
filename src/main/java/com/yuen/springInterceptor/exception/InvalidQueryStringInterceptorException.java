package com.yuen.springInterceptor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.FORBIDDEN,
        code = HttpStatus.FORBIDDEN
)
public class InvalidQueryStringInterceptorException extends RuntimeException{
    public InvalidQueryStringInterceptorException(String message) {
        super(message);
    }
}
