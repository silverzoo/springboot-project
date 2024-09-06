package com.elice.project.ch1105.practice3;

//POJO Class
public class AlarmEvent {

    private String chatUuid;
    private Object source;

    public AlarmEvent(String chatUuid, Object source) {
        this.chatUuid = chatUuid;
        this.source = source;
    }

    public Object getSource() {
        return source;
    }

    public String getChatUuid() {
        return chatUuid;
    }
}
