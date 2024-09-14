package com.elice.project.ch1102.practice5;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.ArrayList;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="POST_ID")
    private Long id;

    private String title;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    // TODO: 1. Post 클래스에 Comment 객체를 참조하는 필드를 추가하세요.
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;


    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
