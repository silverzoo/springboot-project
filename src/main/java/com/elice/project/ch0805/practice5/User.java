package com.elice.project.ch0805.practice5;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    // UserProfile 엔티티와 단방향 @OneToOne 관계 설정
    @OneToOne
    // 외래 키로 사용할 컬럼 지정
    @JoinColumn(name = "user_profile_id")
    private UserProfile userProfile;
}