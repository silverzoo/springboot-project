package com.elice.project.ch1104.practice1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAll();

    Optional<Post> findById(Long id);

    Post save(Post post);

    void delete(Post post);

    // 조회 메서드를 생성합니다.
    List<Post> findByTitleContaining(String keyword);
}
