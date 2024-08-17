package com.elice.project.ch0805.practice6;

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

    // Department 엔티티와 단방향 @ManyToOne 관계 설정
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}