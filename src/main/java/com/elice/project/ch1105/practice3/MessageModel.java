package com.elice.project.ch1105.practice3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageModel {
    private String chatUuid;
    private String sender;
    private String content;

    public MessageModel(String chatUuid, String sender, String content) {
        this.chatUuid = chatUuid;
        this.sender = sender;
        this.content = content;
    }
}
