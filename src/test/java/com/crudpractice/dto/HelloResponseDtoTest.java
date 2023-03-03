package com.crudpractice.dto;

import com.crudpractice.web.dto.HelloResponseDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void testLombok(){
        String name = "test";
        int amount = 100;

        /*
            메인 코드의 HelloResponseDto 에서 생성자를 선언하지 않았음에도,
            @RequiredArgsConstructor 에 의해 final 선언된 필드인 name, amount 가 포함된 생성자가 생성됨
         */
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //HelloResponseDto dto2 = new HelloResponseDto();
        /*
            위의 dto2 가 오류나는 이유는,
            name, amount 가 포함된 생성자가 선언되었기 때문에 기본 생성자는 따로 선언해주지 않는 이상 작동하지 않기 때문
            @NoArgsConstructor 를 선언하면 파라미터가 없는 기본생성자가 생성됨
            @AllArgsConstructor 를 선언하면 모든 필드가 포함된 생성자가 생성됨
         */

        /*
        assertThat
            assertj 라는 테스트 검증 라이브러리의 검증 메서드
        isEqualTo
            assertThat() 의 값과 isEqualTo() 의 값을 비교하여 일치하면 테스트 성공
        Getter
            메인 코드의 HelloResponseDto 에서 get 메서드를 만들지 않았지만
            롬복의 Getter 에 의해 값을 정상적으로 가져올 수 있음
         */
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
