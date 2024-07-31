package com.elice.project.ch0603.practice7;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;

// 지시사항에 따라 코드를 작성해 보세요.
@Component
//@Primary
public class FactorialWithFor implements Factorial {
    @Override
    public void factorial(long n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.println("[for문] " + n +"의 팩토리얼: " + + result);
    }
}

