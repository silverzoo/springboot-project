package com.elice.project.ch1101.practice4;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // POST APIs
    // 게시글을 생성하는 기능
    // Post를 통해 전달받는 파라미터를 범용적으로 사용하기 위해서 Map을 사용
    @PostMapping("/posts/new")
    public Post createPost(@RequestBody Map<String, String> param) {
        String title = param.get("title");
        String content = param.get("contents");

        return postService.savePost(title, content);
    }

    // 게시글을 생성하는 기능
    // PostDTO를 통해 전달받는 파라미터를 사용
    @PostMapping("/posts")
    public Post createPost(@RequestBody PostDTO postDTO) {
        return postService.savePost(postDTO);
    }

}
