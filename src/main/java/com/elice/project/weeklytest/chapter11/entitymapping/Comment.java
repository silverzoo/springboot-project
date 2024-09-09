package com.elice.project.weeklytest.chapter11.entitymapping;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 지시사항을 참고하여 코드를 작성해 보세요.
@Entity
@Table(name = "Comments")
@NoArgsConstructor
@Getter
@Setter
public class Comment {

    // 지시사항을 참고하여 코드를 작성해 보세요.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false, unique = true)
    private String commenter;

    @Column(nullable = true, length = 140)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

}