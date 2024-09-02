package com.elice.project.ch1101.practice4;

public class PostDTO {

    private Long id;
    private String title;
    private String content;

    public PostDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Post toEntity() {
        return new Post(title, content);
    }
}
