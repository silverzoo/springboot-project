package com.elice.project.ch1105.practice3.socket.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OutputMessageModel {

    private String sender;
    private String chatUuid;
    private String content;
    private String time;
    private MessageType type;

    public enum MessageType {
        CHAT, JOIN, LEAVE
    }

    public OutputMessageModel(String sender, String content, MessageType type, String time) {
        this.sender = sender;
        this.content = content;
        this.type = type;
        this.time = time;
    }

    public OutputMessageModel(String sender, String chatUuid, String content, String time, MessageType type) {
        this.sender = sender;
        this.chatUuid = chatUuid;
        this.content = content;
        this.time = time;
        this.type = type;
    }
}
