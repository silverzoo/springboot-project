package com.elice.project.ch1104.practice4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAll();

    Optional<Post> findById(Long id);

    List<Post> findByTitleContainingOrContentContaining(String title, String content);

    Post save(Post post);

    void delete(Post post);

    // @Query 를 사용하여 title 에 해당하는 데이터 반환
    // JPQL: 엔티티 객체를 대상으로 쿼리를 작성
    @Query("SELECT p FROM Post p WHERE p.title = :title")
    List<Post> findByTitleParam(@Param("title") String title);



}