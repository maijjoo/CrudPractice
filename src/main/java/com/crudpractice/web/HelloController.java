package com.crudpractice.web;

import com.crudpractice.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController             //JSON 을 반환하는 컨트롤러
public class HelloController {

    @GetMapping("/hello")   //Get 요청을 받는 API
    public String hello(){
        return "hello";
    }

    /*
    @RequestParam
        외부에서 API 로 넘긴 파라미터를 가져오는 어노테이션
        외부에서 "name", "amount" 로 넘어온 파라미터를 String name, int amount 에 저장
     */
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
