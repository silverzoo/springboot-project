package com.elice.project.ch1105.practice3.chat.model;

import lombok.Getter;

@Getter
public class ChatCreateResponse {
    private boolean success;
    private String content;

    public ChatCreateResponse(boolean success, String content) {
        this.success = success;
        this.content = content;
    }

    public static ChatCreateResponse from(boolean success, String content) {
        return new ChatCreateResponse(success, content);
    }
}
