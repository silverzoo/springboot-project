package com.elice.project.post.service;

import com.elice.project.post.domain.Post;
import com.elice.project.post.dto.PostDTO;
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
    public Post updatePost(Long id, PostDTO postDTO) {
        //기존에 있는 내용에서 가져와야한다
        Post sendData = data
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(
                        p -> {
                            p.setTitle(postDTO.getTitle());
                            p.setContent(postDTO.getContent());
                            return p;
                        }

                ).orElse(null);

        return sendData;
    }

    public void deletePost(Long id) {
        //스트림을 사용한다
        //필터를 적용한다
        //id 값으로 적용한 필터의 객체의 첫번째 객체를 가져온다
        //객체가 있으면 삭제를 진행한다

        //Todo 익명함수를 사용해서 데이터 삭제 진행. list remove 사용해서 삭제
        data
                .stream()
                //list 내의 스트림 상에서 원하는 데이터 추출
                .filter(p -> p.getId().equals(id))
                //해당하는 원소 객체 첫번째 위치에 있는 원소를 반환
                .findFirst()
                //ifPresent()는 Optional, 객체가 값을 가지고 있으면 실행 없으면 넘어감
                .ifPresent(p -> data.remove(p));


//        //스트림이 아닌 방식
//        for(Post p: data){
//            if(p.getId().equals(id-1)) {
//                //data.remove(p);
//                data.remove(Integer.parseInt(p.getId().toString()));
//                return;
//                // 만약 for문 탈출 안하면 이어서 계속 삭제해버려 index null까지 밀어버려 오류가 뜸


    }
}
