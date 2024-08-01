package com.elice.project.ch0604.post.dto;

//Data Transfer Object
//dto 는 Object 와 Object 사이에 데이터를 전달하기 위한 객체
//이 객체는 파라미터 값들을 담고 있다.
public class PostDTO {
    private Long id;
    private String title;
    private String content;

    public PostDTO() {};

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
