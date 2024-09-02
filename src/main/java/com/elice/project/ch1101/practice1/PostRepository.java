package com.elice.project.ch1101.practice1;

import com.elice.project.ch1101.practice3.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// 지시사항에 따라 코드를 작성해 주세요.
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    public List<Post> findAll();
}