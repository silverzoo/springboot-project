package com.elice.project.ch0605.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class EventRegistrationController {

    //변수마다 @RequestParam 주는 방식
    // @PostMapping("/event")
    // public String registerUser(@RequestParam String name, @RequestParam int age) {
    //     return "감사합니다 " + name + "님(" + age + "), 이벤트 참가 신청이 완료되었습니다!";
    // }

    //@RequestParam Map<> 방식
    @PostMapping("/event")
    public String registerUser(@RequestParam Map<String, String> params) {
        String name = params.get("name");
        String age = params.get("age");

        return "감사합니다 " + name + "님(" + age + "), 이벤트 참가 신청이 완료되었습니다!";
    }


}

