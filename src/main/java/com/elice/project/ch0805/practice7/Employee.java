package com.elice.project.ch0805.practice7;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    // Department 엔티티와 양방향 @ManyToOne 관계 설정
    @ManyToOne
    @JoinColumn(name = "department_id")  // 외래 키로 사용할 컬럼 지정
    private Department department;


}