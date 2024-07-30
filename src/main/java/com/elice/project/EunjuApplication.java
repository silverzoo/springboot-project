package com.elice.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class EunjuApplication {
    public static void main(String[] args) {
//      SpringApplication.run(EunjuApplication.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.saveUser("이은주");
    }
}
