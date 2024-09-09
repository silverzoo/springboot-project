package com.elice.project.weeklytest.chapter11.pagenation;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper mapper;

    public MemberController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }

    // 지시사항을 참고하여 코드를 작성해 보세요.

    @GetMapping
    public ResponseEntity<List<Member>> getmembers(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "3") int size) {

        Page<Member> members = memberService.findMembers(page, size);
        List<Member> content = members.getContent();

        if (content.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(content, HttpStatus.OK);
    }

    @GetMapping("/email-search")
    public List<Member> getMemberByEmailEndingWith(@RequestParam(name = "email") String email) {
        return memberService.findMemberByEmailEndingWith(email);
    }
}