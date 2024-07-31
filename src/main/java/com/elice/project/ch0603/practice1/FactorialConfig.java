package com.elice.project.ch0603.practice1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 지시사항에 따라 코드를 작성해 보세요.
@Configuration
@EnableAspectJAutoProxy
public class FactorialConfig {

    // 지시사항에 따라 코드를 작성해 보세요.
    @Bean
    public FactorialTimeAspect factorialTimeAspect() {
        return new FactorialTimeAspect();
    }

    @Bean
    public FactorialLoggingAspect factorialLoggingAspect() {
        return new FactorialLoggingAspect();
    }

    @Bean
    public Factorial factorial() {
        return new FactorialWithRecursion();
    }
}