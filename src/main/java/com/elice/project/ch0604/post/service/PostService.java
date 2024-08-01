package com.elice.project.ch0604.post.service;

import com.elice.project.ch0604.post.domain.Post;
import com.elice.project.ch0604.post.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    //임시 DB
    List<Post> data = new ArrayList<>();

    private Long generateId() {
        if(data.isEmpty()) return 1L;

        //return data.getLast().getId() + 1;
        return data.get(data.size()-1).getId() + 1;
    }

    public List<Post> getAllPosts() {
        //data.add(new Post("제목","내용")); //임시데이터
        return data;
    }

    public Post savePost(PostDTO postDTO) {
        Post post = new Post(postDTO.getTitle(),postDTO.getContent());
        post.setId(generateId());
        data.add(post);

        return post;
    }
}
