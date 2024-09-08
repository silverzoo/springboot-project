package com.elice.project.ch1103.practice2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // 지시사항을 참고하여 코드를 작성해 보세요.

    @Transactional
    public void transfer(Long fromAccountId, Long toAccountId, double amount) {
        // 출금 계좌와 입금 계좌를 조회합니다.
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new RuntimeException("출금 계좌가 존재하지 않습니다."));

        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new RuntimeException("입금 계좌가 존재하지 않습니다."));

        // 지시사항을 참고하여 코드를 작성해 보세요.
        if(fromAccount.getBalance() < amount) {
            throw new InsufficientFundsException("잔액이 부족합니다.");
        }

        // 잔액을 업데이트합니다.
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

    }
}
