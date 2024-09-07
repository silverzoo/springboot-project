package com.elice.project.ch1105.practice3.chat.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatCreateRequest {
    private String chatUuid;
    private String chatTitle;

    public ChatCreateRequest(String chatUuid, String chatTitle) {
        this.chatUuid = chatUuid;
        this.chatTitle = chatTitle;
    }
}
