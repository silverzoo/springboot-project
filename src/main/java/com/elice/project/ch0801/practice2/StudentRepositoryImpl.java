package com.elice.project.ch0801.practice2;

import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", "alice@example.com"));
        students.add(new Student(2, "Bob", "bob@example.com"));
        students.add(new Student(3, "Charlie", "charlie@example.com"));
        return students;
    }
}