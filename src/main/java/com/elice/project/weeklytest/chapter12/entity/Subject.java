package com.elice.project.weeklytest.chapter12.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, updatable = false)
    private int price;

//    @OneToMany(mappedBy = "subject")
//    private List<RegistrationSubject> registrationSubjects = new ArrayList<>();

    public Subject(String name, int price) {
        this.name = name;
        this.price = price;
    }
}