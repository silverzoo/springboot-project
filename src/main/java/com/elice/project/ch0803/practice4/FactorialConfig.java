package com.elice.project.ch0803.practice4;

import com.elice.project.ch0603.practice1.FactorialLoggingAspect;
import com.elice.project.ch0603.practice1.FactorialTimeAspect;
import com.elice.project.ch0803.practice3.factorial.Factorial;
import com.elice.project.ch0803.practice3.factorial.FactorialWithRecursion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;

@Configuration
@EnableAspectJAutoProxy
public class FactorialConfig {

    // 지시사항에 따라 코드를 작성해 보세요.
    //@Order 어노테이션은 실행 순서 우선순위를 부여한다.
    @Bean
    @Order(2)
    public FactorialTimeAspect factorialTimeAspect() {
        return new FactorialTimeAspect();
    }

    @Bean
    @Order(1)
    public FactorialLoggingAspect factorialLoggingAspect() {
        return new FactorialLoggingAspect();
    }

    @Bean
    public Factorial factorial() {
        return new FactorialWithRecursion();
    }

}