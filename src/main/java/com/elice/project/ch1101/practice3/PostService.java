package com.elice.project.ch1101.practice3;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 2-1 전체 리스트 조회 서비스
    public List<Post> getAllPosts() {
        return this.postRepository.findAll();
    }

    // 2-2 id 기반 조회 서비스
    public Post getPostById(Long id) {
        return this.postRepository.findById(id).orElse(null);
    }

}
