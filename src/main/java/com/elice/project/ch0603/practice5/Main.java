package com.elice.project.ch0603.practice5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService1 = context.getBean(UserService.class);
        UserService userService2 = context.getBean(UserService.class);

        System.out.println("UserService 1 ID: " + userService1.getId());
        System.out.println("UserService 2 ID: " + userService2.getId());

        if (userService1 == userService2) {
            System.out.println("같은 인스턴스입니다.");
        } else {
            System.out.println("다른 인스턴스입니다.");
        }
    }
}
