package com.elice.project.ch0705.practice3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    @GetMapping("/students")
    public String getStudents(Model model) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", "alice@example.com", "2학년"));
        students.add(new Student(2, "Bob", "bob@example.com", "3학년"));
        students.add(new Student(3, "Charlie", "charlie@example.com", "1학년"));

        // 지시사항을 참고하여 코드를 작성해 보세요.
        model.addAttribute("students", students);

        return "students";
    }
}
