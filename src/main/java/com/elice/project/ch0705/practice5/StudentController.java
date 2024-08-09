package com.elice.project.ch0705.practice5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(1, "Alice", "alice@example.com", "2학년"));
        students.add(new Student(2, "Bob", "bob@example.com", "3학년"));
        students.add(new Student(3, "Charlie", "charlie@example.com", "1학년"));
    }

    @GetMapping
    public String getStudents(Model model) {
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/{id}")
    public String getStudentDetails(@PathVariable Integer id, Model model) {


        // 지시 사항을 참고하여 코드를 작성해 보세요.
        Student student = students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);

        model.addAttribute("student", student);

        return "studentDetail";
    }
}
