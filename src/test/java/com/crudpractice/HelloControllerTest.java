package com.crudpractice;

import com.crudpractice.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

/*
@RunWith
    JUnit 에 내장된 실행자 외에 다른 실행자를 실행
    스프링부트 테스트와 JUnit 사이의 연결자 역할 수행
@WebMvcTest
    스프링 테스트 어노테이션중 Web 에 집중할 수 있는 어노테이션
    @Controller, @ControllerAdvice 등 컨트롤러 관련 테스트 어노테이션 사용 가능
    @Service, @Component, @Repository 등은 사용 불가
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {


    /*
    @Autowired
        스프링이 관리하는 빈을 주입받기 위해 사용
    MockMvc
        웹 API 를 테스트 할 때 사용
        MockMvc 가 제공하는 다양한 함수(GET, POST 등)를 통해
        실제로 Controller 객체를 사용하는 것 처럼 테스트 가능
     */
    @Autowired
    private MockMvc mvc;

    @Test
    public void returnHello() throws Exception {
        String hello = "hello";                           // 테스트 문구

        mvc.perform(get("/hello"))              // /hello 주소로 GET 요청
                .andExpect(status().isOk())               // HTTP Header 의 Status 를 검증(200,404,500 등)
                                                          // 여기선 Ok(200) 인지 아닌지 검증
                .andExpect(content().string(hello));      // GET 요청한 주소의 Content 와
                                                          // 위에서 선언한 테스트문구가 일치하는지 검증
    }

    @Test
    public void returnHelloDto() throws Exception {
        String name = "hello";
        int amount = 100;

        mvc.perform(get("/hello/dto")
                .param("name", name)                                // API 테스트에 사용될 요청 파라미터 설정
                .param("amount", String.valueOf(amount)))           // String 만 허용되기 때문에 int 형인 amount 를 형변환
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))        // JSON 응답값을 필드별로 검증
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
