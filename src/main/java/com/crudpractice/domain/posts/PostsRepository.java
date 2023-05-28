package com.crudpractice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}

/*
ibatis, MyBatis 등에서 Dao 라고 불리는 DB Layer 접근자
JPA 에선 Repository 라고 부르며 인터페이스로 생성
JpaRepository<Entity 클래스, PK 타입> 를 상속하면 기본적인 CRUD 메서드 자동 생성
Entity 클래스와 Entity Repository 는 같은 패키지에서 관리
 */
