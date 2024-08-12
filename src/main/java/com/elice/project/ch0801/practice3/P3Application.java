//package com.elice.project.ch0801.practice3;
//
//import com.elice.project.ch0801.practice3.repository.ContactRepository;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Profile;
//
//@SpringBootApplication
//public class P3Application {
//
//    public static void main(String[] args) {
//        SpringApplication.run(P3Application.class, args);
//    }
//
//    @Bean
//    @Profile("local")
//    public DataInit dataInit(ContactRepository contactRepository) {
//        return new DataInit(contactRepository);
//    }
//}
