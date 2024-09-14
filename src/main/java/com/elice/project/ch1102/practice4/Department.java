package com.elice.project.ch1102.practice4;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // 지시사항을 참고하여 코드를 작성해 보세요.
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}