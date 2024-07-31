package com.elice.project.ch0603.practice1;

public class FactorialProxy implements Factorial{

    private Factorial delegator;

    public FactorialProxy(Factorial delegator) {
        this.delegator = delegator;
    }

    @Override
    public void factorial(long n) {
        long startTime = System.nanoTime();
        delegator.factorial(n);
        long endTime = System.nanoTime();
        System.out.printf("호출 클래스: %s\n", delegator.getClass().getSimpleName());
        System.out.printf("실행 시간: %dns\n", (endTime - startTime));
        System.out.println("---------------------------------------");
    }
}