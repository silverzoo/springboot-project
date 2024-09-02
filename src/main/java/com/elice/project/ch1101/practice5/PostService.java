package com.elice.project.ch1101.practice5;

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

    public Post savePost(String title, String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        return postRepository.save(post);
    }

    public Post savePost(PostDTO postDTO) {
        return postRepository.save(postDTO.toEntity());
    }

    // 1. 게시글을 수정하는 기능
    public Post updatePost(PostDTO postDTO) {
        Post post = postRepository.findById(postDTO.getId()).orElse(null);

        if(post != null) {
            post.setTitle(postDTO.getTitle());
            post.setContent(postDTO.getContent());
        }

        return postRepository.save(post);
    }


    // 2. 게시글을 삭제하는 기능
    public void deletePost(Long id) {
        Post post  = postRepository.findById(id).orElse(null);
        postRepository.delete(post);
    }
}