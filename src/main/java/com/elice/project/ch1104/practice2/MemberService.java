package com.elice.project.ch1104.practice2;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 지시사항에 따라 기능을 작성해 주세요.
    public Member signUp(SignUpDto signUpDto) {
        String nickname = signUpDto.getNickname();
        String email = signUpDto.getEmail();

        if(memberRepository.existsByNickname(nickname) || memberRepository.existsByEmail(email)) {
            return null;
        }

        return memberRepository.save(signUpDto.toEntity());
    }

}
