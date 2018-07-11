package com.yuen.springInterceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/yuen")
    public String asd(){
        return "asd";
    }

    @GetMapping("/me")
    public String me(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit){
        if(page == null) { page = 0; }
        if(limit == null) { limit = 100; }

        return page.toString() + " " + limit.toString();
    }
}
