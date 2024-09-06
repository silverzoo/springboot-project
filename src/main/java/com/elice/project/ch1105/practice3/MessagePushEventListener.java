package com.elice.project.ch1105.practice3;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MessagePushEventListener {

    private final MessageService messageService;

    @EventListener
    public void eventListener(AlarmEvent event) {
        String chatUuid = event.getChatUuid();
        ErrorCode errorCode = (ErrorCode) event.getSource();
        MessageModel messageModel = new MessageModel(chatUuid, "관리자", errorCode.getDetailMessage());
        /**
         * [지시사항 5]
         * 메시지의 목적지와 messageModel 객체를 파라미터에 담아 messageService의 sendMessage 메서드를 호출한다.
         */
        messageService.sendMessage("/topic/chat/" + chatUuid, messageModel);

    }
}

