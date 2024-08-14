package com.elice.project.ch0803.practice3.factorial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class FactorialConfig {

    @Bean
    public FactorialTimeAspect factorialTimeAspect() {
        return new FactorialTimeAspect();
    }

    // 로깅 Aspect 클래스 빈 등록
    @Bean
    public FactorialLoggingAspect factorialLoggingAspect() {
        return new FactorialLoggingAspect();
    }

    @Bean
    public Factorial factorial() {
        return new FactorialWithRecursion();
    }
}
