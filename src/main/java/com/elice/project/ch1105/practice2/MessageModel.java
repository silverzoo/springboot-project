package com.elice.project.ch1105.practice2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageModel {
    private String sender;
    private String content;
    private String chatUuid;

    public MessageModel(String sender, String content, String chatUuid) {
        this.sender = sender;
        this.content = content;
        this.chatUuid = chatUuid;
    }
}
