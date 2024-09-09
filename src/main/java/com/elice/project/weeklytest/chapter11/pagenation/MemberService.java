package com.elice.project.weeklytest.chapter11.pagenation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 지시사항을 참고하여 코드를 작성해 보세요.
    public Page<Member> findMembers(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page-1, size, Sort.by("memberId").ascending());
        return memberRepository.findAll(pageRequest);
    }

    public List<Member> findMemberByEmailEndingWith(String email) {
        return memberRepository.findMemberByEmailEndingWith(email);
    }

}