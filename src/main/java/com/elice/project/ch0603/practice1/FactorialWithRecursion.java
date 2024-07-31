package com.elice.project.ch0603.practice1;

import org.springframework.stereotype.Component;

@Component
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

