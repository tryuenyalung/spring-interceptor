package com.yuen.springInterceptor.interceptor;

import com.yuen.springInterceptor.exception.InvalidQueryStringInterceptorException;
import com.yuen.springInterceptor.exception.NoTokenPresentInterceptorException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String header = request.getHeader("access_token");
        String pageQueryString = request.getParameter("page");
        String limitQueryString = request.getParameter("limit");

        authenticate(header);
        isPageGreaterThanZero(pageQueryString);
        isLimitGreaterThanOne(limitQueryString);
        return true;
    }

    private void authenticate(String header) {
        if( header == null ) throw new NoTokenPresentInterceptorException("no token present on header");
    }

    private void isPageGreaterThanZero(String pageQueryString){
        if( pageQueryString != null && Integer.valueOf(pageQueryString) < 0 ) throw new InvalidQueryStringInterceptorException("Page must not be less than 0");
    }

    private void isLimitGreaterThanOne(String limitQueryString){
        if( limitQueryString != null && Integer.valueOf(limitQueryString) < 1  ) throw new InvalidQueryStringInterceptorException("Limit must be greater than 0");
    }



}
