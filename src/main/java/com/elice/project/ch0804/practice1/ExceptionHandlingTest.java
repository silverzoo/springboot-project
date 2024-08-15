package com.elice.project.ch0804.practice1;

public class ExceptionHandlingTest {

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.deposit(100000);

        // 지시사항을 참고하여 코드를 작성해 보세요.
        try {
            bank.withdraw(200000);
        } catch (InsufficientException e) {
            System.err.println("에러 메시지: " + e.getMessage());
        }
    }
}
