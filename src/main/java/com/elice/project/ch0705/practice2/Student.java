package com.elice.project.ch0705.practice2;

public class Student {
    private Integer id;
    private String name;
    private String email;
    private String grade;

    public Student(Integer id, String name, String email, String grade) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGrade() {
        return grade;
    }

}