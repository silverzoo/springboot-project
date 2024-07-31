package com.elice.project.ch0603.practice1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactorialTest {
    public static void main(String[] args) {

        // 지시사항에 따라 코드를 작성해 보세요.
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FactorialConfig.class);
        Factorial f = context.getBean("factorial", Factorial.class);
        f.factorial(20);
    }
}