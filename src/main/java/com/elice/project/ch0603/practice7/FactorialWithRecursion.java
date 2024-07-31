package com.elice.project.ch0603.practice7;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// 지시사항에 따라 코드를 작성해 보세요.
//자동 주입시 같은 타입이 2개 이상인데 우선순위가 정해져있지 않으면 에러가 난다.
@Component
@Primary
public class FactorialWithRecursion implements Factorial {
    @Override
    public void factorial(long n) {
        long result = printFactorialRecursive(n, 1);
        System.out.println("[재귀문] " + n + "의 팩토리얼: " + result);
    }

    private static long printFactorialRecursive(long n, long accumulator) {
        if (n == 0) {
            return accumulator;
        }

        return printFactorialRecursive(n - 1, n * accumulator);
    }
}



