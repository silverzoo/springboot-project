package com.elice.project.weeklytest.chapter11.enumgrade;

import jakarta.persistence.*;

// 지시사항에 따라 Member 엔티티를 완성해 주세요.
@Entity
@Table(name = "member")
public class Member {

    // 여기에 컬럼과 매핑되는 칼럼을 선언해 주세요.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String nickname;
    @Enumerated(EnumType.STRING)
    private Grade grade;


    public Member(String email, String password, String nickname) {

        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.grade = Grade.Bronze;
    }

    public Member() {

    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Grade getGrade() {
        return grade;
    }
}
