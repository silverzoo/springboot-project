package com.elice.project.ch1101.practice2;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member signUp(SignUpDto signUpDto) {
        return memberRepository.save(signUpDto.toEntity());
    }

    // updateNickname 메서드를 작성해 주세요.
    public Member updateNickname(Long id, String nickname) {
        // 회원 조회
        Member member = memberRepository.findById(id).orElse(null);

        // 닉네임 중복 확인
        if(!memberRepository.existsByNickname(nickname)) {
            // 닉네임 변경
            member.setNickname(nickname);
        }
        //findById, findAll 등으로 조회된 엔티티는 영속 상태라서 member만 리턴해줘도 transaction 처리가 됨
        //return member; ok
        return memberRepository.save(member);
    }

}
