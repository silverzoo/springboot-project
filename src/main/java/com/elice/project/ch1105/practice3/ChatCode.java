package com.elice.project.ch1105.practice3;

import lombok.Getter;

@Getter
public enum ChatCode {

    ORDER_ISSUE("chat-001", "주문 이슈방");

    private final String chatUuid;
    private final String message;

    ChatCode(String chatUuid, String message) {
        this.chatUuid = chatUuid;
        this.message = message;
    }
}
