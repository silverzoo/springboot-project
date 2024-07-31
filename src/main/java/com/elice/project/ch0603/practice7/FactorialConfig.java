package com.elice.project.ch0603.practice7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 지시사항에 따라 코드를 작성해 보세요.
@EnableAspectJAutoProxy
@Configuration
@ComponentScan
public class FactorialConfig {

    // 지시사항에 따라 코드를 작성해 보세요.
    //@Bean 으로 수동 등록한 빈 제거 -> 스캔대상이 되는 클래스에 @Component 추가

//     public FactorialTimeAspect factorialTimeAspect() {
//         return new FactorialTimeAspect();
//     }
//
//     public FactorialLoggingAspect factorialLoggingAspect() {
//         return new FactorialLoggingAspect();
//     }
//
//     public Factorial factorial() {
//         return new FactorialWithRecursion();
//     }
}