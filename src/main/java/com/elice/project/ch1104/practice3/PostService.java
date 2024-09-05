package com.elice.project.ch1104.practice3;

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

//    public Post savePost(PostDTO postDTO) {
//        return postRepository.save(postDTO.toEntity());
//    }
//
//    public Post updatePost(PostDTO postDTO) {
//        Post post = postRepository.findById(postDTO.getId()).orElse(null);
//        post.setTitle(postDTO.getTitle());
//        post.setContent(postDTO.getContent());
//        return post;
//    }
//
//    public void deletePost(Long id) {
//        Post post = postRepository.findById(id).orElse(null);
//        postRepository.delete(post);
//    }

    // 1. 특정 글자가 포함된 타이틀을 Id 순으로 오름차순 정렬
    public List<Post> getFindByTitleContainsOrderByIdAsc(String title){
        return postRepository.findByTitleContainsOrderByIdAsc(title);
    }

    // 2. 특정 글자가 포함된 타이틀을 Id 순으로 내림차순 정렬
    public List<Post> getFindByTitleContainsOrderByIdDesc(String title){
        return postRepository.findByTitleContainsOrderByIdDesc(title);
    }

}