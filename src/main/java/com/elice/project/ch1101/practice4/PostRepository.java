package com.elice.project.ch1101.practice4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAll();

    Optional<Post> findById(Long id);

    List<Post> findByTitleContainingOrContentContaining(String title, String content);

    // 입력
    Post save(Post post);
}
