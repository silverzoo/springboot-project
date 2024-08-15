package com.elice.project.ch0804.practice5;

public class ContactNotFoundException extends RuntimeException {

    public ContactNotFoundException() {
        super("연락처를 찾을 수 없습니다.");
    }
}
