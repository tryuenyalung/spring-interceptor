package com.yuen.springInterceptor.config;

import com.sun.org.glassfish.gmbal.Description;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Description("reference :: https://stackoverflow.com/questions/40248640/change-spring-boots-default-json-error-response-structure?rq=1")
public class ErrorResponse {

    @Bean
    public ErrorAttributes errorAttributes(){
        return new DefaultErrorAttributes(){

            @Override
            public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
                Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
                Map<String, Object> error = new HashMap<>();
                error.put("code", errorAttributes.get("status"));
                error.put("status", errorAttributes.get("error"));
                error.put("message", errorAttributes.get("message"));
                return error;
            }

        };
    }//ErrorAttributes

}