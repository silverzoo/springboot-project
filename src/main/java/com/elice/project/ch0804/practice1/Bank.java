package com.elice.project.ch0804.practice1;

public class Bank {

    private int balance;

    public void deposit(int money) {
        balance = balance + money;
    }

    // 지시사항을 참고하여 코드를 작성해 보세요.
    public void withdraw(int money) throws InsufficientException {
        if(money > balance) {
            throw new InsufficientException("잔고가 부족합니다.");
        }
        balance -= money;
    }
}
