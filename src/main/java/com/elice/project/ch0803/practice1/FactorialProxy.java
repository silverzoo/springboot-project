package com.elice.project.ch0803.practice1;

public class FactorialProxy implements Factorial{

    private Factorial delegator;

    // 생성자 주입을 통해 메서드 호출
    public FactorialProxy (Factorial delegator) {
        this.delegator = delegator;
    }

    @Override
    public void factorial(long n) {
        // 지시사항을 참고하여 코드를 작성해 보세요.

        //시간로직 구현
        long startTime = System.nanoTime();

        //인터페이스 메서드 호출
        delegator.factorial(n);

        long endTime = System.nanoTime();

        // 프록시 작성 이후 아래 세 줄의 주석을 해제해 주세요.
        System.out.printf("호출 클래스: %s\n", delegator.getClass().getSimpleName());
        System.out.printf("실행 시간: %dns\n", (endTime - startTime));
        System.out.println("---------------------------------------");
    }
}
