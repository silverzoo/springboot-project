package com.elice.project.ch1104.practice7;

import com.elice.project.ch1104.practice7.Repository.ContactRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// 지시사항을 참고하여 코드를 작성해 보세요.
@EnableJpaAuditing
@SpringBootApplication
public class EliceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EliceApplication.class, args);
    }

    @Bean
    @Profile("local")
    public DataInit dataInit(ContactRepository contactRepository) {
        return new DataInit(contactRepository);
    }
}