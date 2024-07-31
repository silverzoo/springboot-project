package com.elice.project.ch0603.practice6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {
        // 싱글톤 스코프 테스트
        Counter singletonCounter1 = (Counter) ctx.getBean("singletonCounter");
        System.out.println("싱글톤 스코프:");
        System.out.println("첫 번째 빈 카운터 값: " + singletonCounter1.increment());
        System.out.println("첫 번째 빈 카운터 값: " + singletonCounter1.increment());

        // 프로토타입 스코프 테스트
        Counter prototypeCounter1 = (Counter) ctx.getBean("prototypeCounter");
        Counter prototypeCounter2 = (Counter) ctx.getBean("prototypeCounter");
        System.out.println("프로토타입 스코프:");
        System.out.println("첫 번째 빈 카운터 값: " + prototypeCounter1.increment());
        System.out.println("두 번째 빈 카운터 값: " + prototypeCounter2.increment());
    }
}