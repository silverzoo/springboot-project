package com.elice.project.weeklytest.chapter11.pagenation;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

    // 지시사항을 참고하여 코드를 작성해 보세요.
//    @OneToMany(mappedBy = "member")
//    private List<Registration> registrations = new ArrayList<>();

    public Member(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}