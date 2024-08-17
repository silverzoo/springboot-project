package com.elice.project.ch0805.practice7;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Employee 엔티티와 양방향 @OneToMany 관계 설정
    // mappedBy = "department"는 Employee 엔티티의 department 필드와 연결됨
    @OneToMany(mappedBy = "department")
    private List<Employee> employees = new ArrayList<>();



}