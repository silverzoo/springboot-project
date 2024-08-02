package com.elice.project.ch0604.practice1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/")
    public String home(Model model) {
        // Model로 전달되는 값을 변경해서 확인해보세요.
        model.addAttribute("posts", "이은주");
        return "home";
    }

    @GetMapping("/home2")
    @ResponseBody
    public String rest() {
        return "static";
    }

    //model 객체로 MVC 실습
    @GetMapping("/c4")
    public String c4(Model model) {
        String prefixDescription = "description: ";
        model.addAttribute("description", prefixDescription + "c4 레이서 소개페이지 입니다.");
        model.addAttribute("message", "안녕하세요 c4 레이서 여러분!");
        return "c4";
    }

}
