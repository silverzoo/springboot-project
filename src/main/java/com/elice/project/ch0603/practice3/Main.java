package com.elice.project.ch0603.practice3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 지시사항을 참고하여 코드를 작성해 보세요.
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] allBeanNames = context.getBeanDefinitionNames();

        for(String beanName : allBeanNames) {
            Object bean = context.getBean(beanName);
            //getClass()는 클래스 객체 정보
            //getName()은 각 패키지명이 포함된 클래스명
            //getSimpleName()은 패키지 경로가 포함되지 않은 클래스명
            System.out.println("빈 이름: " + beanName + ", 타입: " + bean.getClass().getName());
        }

    }
}
