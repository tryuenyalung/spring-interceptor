package com.yuen.springInterceptor.config;

import com.yuen.springInterceptor.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Description("Cannot use @ControllerAdvice on interceptor, workaround::configure the exception with status and code")
@Configuration
public class GlobalInterceptor implements WebMvcConfigurer {

    private AuthInterceptor authInterceptor;


    public GlobalInterceptor(AuthInterceptor authInterceptor) {
        this.authInterceptor = authInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/yuen");

        registry.addInterceptor(authInterceptor).addPathPatterns("/me");
    }
}
