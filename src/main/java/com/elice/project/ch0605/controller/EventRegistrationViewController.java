package com.elice.project.ch0605.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventRegistrationViewController {
    @GetMapping("/event")
    public String getUserInfo() {
        return "userInfoForm";
    }
}
