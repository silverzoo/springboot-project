package com.elice.project.ch1105.practice2;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Controller
public class WebSocketController {

    //[지시사항 2-1]
    //[지시사항 2-2]
    @MessageMapping("/message/send/{chatUuid}")
    @SendTo("/topic/chat/{chatUuid}")
    public OutputMessageModel sendMessage(@Payload MessageModel messageModel, @DestinationVariable String chatUuid) {
        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessageModel(messageModel.getSender(), messageModel.getChatUuid(),
                messageModel.getContent(), time, OutputMessageModel.MessageType.CHAT);
    }
}