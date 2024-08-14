package com.elice.project.ch0803.practice1;

public class FactorialWithFor implements Factorial {
    @Override
    public void factorial(long n) {
        long startTime = System.nanoTime();

        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        long endTime = System.nanoTime();
        System.out.println("[for문] " + n +"의 팩토리얼: " + + result);
        // 프록시 작성 이후 아래 세 줄은 주석 처리해 주세요.
        // System.out.println("호출 클래스: " + getClass().getSimpleName());
        // System.out.printf("실행 시간: %dns\n", (endTime - startTime));
        // System.out.println("---------------------------------------");
    }
}
