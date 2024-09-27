package com.elice.project.weeklytest.chapter13;

import com.elice.project.weeklytest.chapter13.member.entity.Member;
import com.elice.project.weeklytest.chapter13.member.repository.MemberRepository;
import com.elice.project.weeklytest.chapter13.subject.entity.Subject;
import com.elice.project.weeklytest.chapter13.subject.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@RequiredArgsConstructor
public class DataInit {

    private final SubjectRepository subjectRepository;
    private final MemberRepository memberRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        log.info("init stub data");
        subjectRepository.save(new Subject("도레미 파이썬 Vol.1", 119000));
        subjectRepository.save(new Subject("TOPA 3급 자격증 6주 완성", 249000));
        subjectRepository.save(new Subject("만들며 배우는 HTML/CSS", 119000));
        subjectRepository.save(new Subject("당신의 삶을 바꿀 생성 AI의 A-Z", 150000));
        subjectRepository.save(new Subject("프로젝트로 배우는 SQL 핵심 완성", 408000));
        subjectRepository.save(new Subject("제대로 배워 딱 붙는 SQLD", 142000));
        subjectRepository.save(new Subject("성공하는 서비스를 위한 UX 포인트", 99000));
        subjectRepository.save(new Subject("기초부터 배우는 프론트엔드 A-Z", 95000));
        subjectRepository.save(new Subject("딥러닝을 이용한 자연어 처리", 170000));
        subjectRepository.save(new Subject("클라우드 컴퓨팅", 180000));
        subjectRepository.save(new Subject("ChatGPT를 넘어 LangChain", 200000));
        subjectRepository.save(new Subject("모르면 안되는 기초 소양, 생성 AI 개론", 150000));
        memberRepository.save(new Member("엘리스", "elice@gmail.com", "01011112222"));
        memberRepository.save(new Member("이상한", "stranger@gmail.com", "01032835222"));
        memberRepository.save(new Member("토끼", "rabbit@gmail.com", "01032825232"));
    }
}
