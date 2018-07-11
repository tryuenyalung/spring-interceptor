package com.yuen.springInterceptor.config;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler({ NoTokenPresentInterceptorException.class })
//    public ResponseEntity badRequestHandler(Exception ex) {
//        return ResponseEntity.badRequest().body(
//                ApiResponse.builder().code(400)
//                        .status(HttpStatus.BAD_REQUEST.toString())
//                        .message(ex.getMessage())
//        );
//    }



}
