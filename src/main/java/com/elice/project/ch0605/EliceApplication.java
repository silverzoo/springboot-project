//package com.elice.project.ch0605;
//
//import com.elice.project.ch0605.repository.ContactRepository;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Profile;
//
//@SpringBootApplication
//public class EliceApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(EliceApplication.class, args);
//    }
//
//    @Bean
//    @Profile("local")
//    public DataInit dataInit(ContactRepository contactRepository) {
//        return new DataInit(contactRepository);
//    }
//}
