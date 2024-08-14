package com.elice.project.ch0803.practice1;

public class FactorialWithRecursion implements Factorial {
    @Override
    public void factorial(long n) {
        long startTime = System.nanoTime();

        long result = printFactorialRecursive(n, 1);

        long endTime = System.nanoTime();
        System.out.println("[재귀문] " + n + "의 팩토리얼: " + result);
        // 프록시 작성 이후 아래 세 줄은 주석 처리해 주세요.
        // System.out.println("호출 클래스: " + getClass().getSimpleName());
        // System.out.printf("실행 시간: %dns\n", (endTime - startTime));
        // System.out.println("---------------------------------------");
    }

    private static long printFactorialRecursive(long n, long accumulator) {
        if (n == 0) {
            return accumulator;
        }

        return printFactorialRecursive(n - 1, n * accumulator);
    }
}

