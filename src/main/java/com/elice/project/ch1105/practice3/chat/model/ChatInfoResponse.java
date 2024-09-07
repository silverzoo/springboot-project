package com.elice.project.ch1105.practice3.chat.model;

import lombok.Getter;

@Getter
public class ChatInfoResponse {
    private String chatUuid;
    private String chatTitle;

    public ChatInfoResponse(String chatUuid, String chatTitle) {
        this.chatUuid = chatUuid;
        this.chatTitle = chatTitle;
    }
}
