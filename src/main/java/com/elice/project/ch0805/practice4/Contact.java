package com.elice.project.ch0805.practice4;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 지시사항을 참고하여 코드를 작성해 보세요.
@Entity
@Table(name = "Contacts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contact {
    // 지시사항을 참고하여 코드를 작성해 보세요.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDENTITY 전략으로 기본 키 자동 생성
    private Long contactId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, updatable = true)
    private String phoneNumber;

    @Column(nullable = true, updatable = false)
    private String email;
}