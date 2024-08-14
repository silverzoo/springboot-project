package com.elice.project.ch0803.practice2.factorial;

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
