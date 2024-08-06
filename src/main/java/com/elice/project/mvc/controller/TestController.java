package com.elice.project.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/")
    public String getIndexPage(){
        return "index";
    }

    @GetMapping("/home")
    public String getHomePage(){
        return "home";
    }

    @GetMapping("/about")
    public String getAboutPage(){
        return "about";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

}