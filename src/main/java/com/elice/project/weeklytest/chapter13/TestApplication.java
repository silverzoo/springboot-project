package com.elice.project.weeklytest.chapter13;

import com.elice.project.weeklytest.chapter13.member.repository.MemberRepository;
import com.elice.project.weeklytest.chapter13.subject.repository.SubjectRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

//    @Bean
//    @Profile("local")
//    public DataInit stubDataInit(SubjectRepository subjectRepository, MemberRepository memberRepository) {
//        return new DataInit(subjectRepository, memberRepository);
//    }
}