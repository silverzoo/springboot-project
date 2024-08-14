package com.elice.project.ch0803.practice1;

public class FactorialTest {
    public static void main(String[] args) {

        // 프록시 작성 이전
        // FactorialWithFor factorialWithFor = new FactorialWithFor();
        // factorialWithFor.factorial(20);

//         FactorialWithRecursion factorialWithRecursion = new FactorialWithRecursion();
        // factorialWithRecursion.factorial(20);

        // 프록시 작성 이후
        FactorialProxy factorialProxy = new FactorialProxy(new FactorialWithFor());
        factorialProxy.factorial(20);

        FactorialProxy factorialProxy2 = new FactorialProxy(new FactorialWithRecursion());
        factorialProxy2.factorial(20);
    }
}
