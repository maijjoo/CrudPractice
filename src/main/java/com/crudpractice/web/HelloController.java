package com.crudpractice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController             //JSON을 반환하는 컨트롤러
public class HelloController {

    @GetMapping("/hello")   //Get 요청을 받는 API
    public String hello(){
        return "hello";
    }
}
