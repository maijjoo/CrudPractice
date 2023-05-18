package com.crudpractice.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    /*
    @AFTER
        단위 테스트가 끝날 때마다 수행되는 메서드 지정
        일반적으로 배포 전 전체 테스트를 수행할 때 테스트간 데이터 침범을 막기 위해 사용
        여러 테스트가 동시에 수행되면 테스트용 데이터베이스인 h2 에 데이터가 남아 다음 테스트 실행에 영향을 줌
     */
    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void saveLoadTest(){

        String title = "test post";
        String content = "test text";

        postsRepository.save(Posts.builder()             //posts 테이블에 insert(id 값 없을때)/update(id 값 있을때) 쿼리 실행
                .title(title)
                .content(content)
                .author("developer")
                .build());

        List<Posts> postsList = postsRepository.findAll(); //posts 테이블의 모든 데이터 조회

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void createBaseTimeEntity(){
        //given
        LocalDateTime now = LocalDateTime.of(2023,5,13,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>> createdDate = " + posts.getCreatedDate() + ", modifiedDate = " + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
