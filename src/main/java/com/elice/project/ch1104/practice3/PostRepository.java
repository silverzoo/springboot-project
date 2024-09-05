package com.elice.project.ch1104.practice3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAll();

    Optional<Post> findById(Long id);

    List<Post> findByTitleContainingOrContentContaining(String title, String content);

    Post save(Post post);

    void delete(Post post);

    // 1. 특정 글자가 포함된 타이틀을 Id 순으로 오름차순 정렬
    List<Post> findByTitleContainsOrderByIdAsc(String title);


    // 2. 특정 글자가 포함된 타이틀을 Id 순으로 내림차순 정렬
    List<Post> findByTitleContainsOrderByIdDesc(String title);


}