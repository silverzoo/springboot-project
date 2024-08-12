package com.elice.project.ch0801.practice2;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    // 지시사항에 따라 코드를 작성해 보세요.
    // StudentRepositoryImpl studentRepositoryImpl = new StudentRepositoryImpl();

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    List<Student> getStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

}