package com.elice.project.ch0803.practice2.factorial;

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

    @Bean
    public Factorial factorial() {
        return new FactorialWithRecursion();
    }
}