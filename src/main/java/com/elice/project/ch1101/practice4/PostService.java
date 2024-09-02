package com.elice.project.ch1101.practice4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> getPostsByTitleContainingOrContentContaining(String title, String content) {
        return postRepository.findByTitleContainingOrContentContaining(title, content);
    }

    // 2-a 입력방법 1
    public Post savePost(String title, String content) {
        return postRepository.save(new Post(title, content));
    }

    // 2-b 입력방법 2: DTO를 활용하는 방법
    public Post savePost(PostDTO postDTO) {
        return postRepository.save(postDTO.toEntity());
    }
}
