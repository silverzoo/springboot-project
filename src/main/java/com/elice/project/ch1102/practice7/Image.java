package com.elice.project.ch1102.practice7;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "IMAGE")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="image_id")
    private Long id;

    private String imgUrl;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    // TODO: 코드 입력
    //  Image N : Post 1
    //  FK : post_id
    //  주인(owner) : Image
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


    public Image(String imgUrl, Post post) {
        this.imgUrl = imgUrl;
        this.post = post;

    }

}
