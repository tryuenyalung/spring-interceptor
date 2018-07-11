package com.yuen.springInterceptor.exception;

import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@Description("Cannot use @ControllerAdvice on interceptor, workaround::configure the exception with status and code")
@ResponseStatus(
        value = HttpStatus.BAD_REQUEST,
        code = HttpStatus.BAD_REQUEST
)
public class NoTokenPresentInterceptorException extends RuntimeException {
    public NoTokenPresentInterceptorException(String message) {
        super(message);
    }
}
