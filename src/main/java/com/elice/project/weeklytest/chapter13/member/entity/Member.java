package com.elice.project.weeklytest.chapter13.member.entity;

import com.elice.project.weeklytest.chapter13.subject.registration.Registration;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String name;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "member")
    private List<Registration> registrations = new ArrayList<>();

    public Member(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Role{
        USER("ROLE_USER", "일반 회원"),
        ADMIN("ROLE_ADMIN", "관리자");

        private final String key;
        private final String title;
    }
}
