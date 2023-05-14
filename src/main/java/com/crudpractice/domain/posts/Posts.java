package com.crudpractice.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity                     // 테이블과 링크될 클래스임을 나타내는 어노테이션
public class Posts {

    @Id                                                     // 해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // PK 의 생성규칙 (IDENTITY, AUTO, SEQUENCE, TABLE)
    private Long id;

    @Column(length = 500, nullable = false)                 // 테이블의 칼럼을 나타내며, 선언하지 않아도 클래스 내의 필드는 칼럼이 되지만
    private String title;                                   // 문자열의 사이즈, 타입 등의 옵션을 조절할 때 선언

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
