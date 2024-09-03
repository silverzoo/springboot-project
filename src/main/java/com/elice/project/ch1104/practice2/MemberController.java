package com.elice.project.ch1104.practice2;

import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public Member signupMember(@RequestBody SignUpDto signUpDto) {
        return memberService.signUp(signUpDto);
    }

}
