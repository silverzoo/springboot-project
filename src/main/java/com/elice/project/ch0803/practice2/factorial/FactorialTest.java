package com.elice.project.ch0803.practice2.factorial;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactorialTest {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(FactorialConfig.class);
        Factorial factorial = applicationContext.getBean("factorial", Factorial.class);
        factorial.factorial(20);

        applicationContext.close();
    }
}
