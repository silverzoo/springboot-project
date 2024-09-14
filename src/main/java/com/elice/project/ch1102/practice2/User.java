package com.elice.project.ch1102.practice2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    // 지시사항을 참고하여 코드를 작성해 보세요.
    @OneToOne
    @JoinColumn(name = "user_profile_id")
    private UserProfile userProfile;

}