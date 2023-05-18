package com.crudpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication                  //스프링부트 자동 설정 어노테이션
public class Application {              //프로젝트 메인클래스
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);     //내장 WAS 실행
    }
}
