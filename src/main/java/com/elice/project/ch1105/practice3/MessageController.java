package com.elice.project.ch1105.practice3;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@RequiredArgsConstructor
@Controller
public class MessageController {

    private final MessageChatService messageChatService;

    /**
     * [지시사항 3 참고]
     */
    @MessageMapping("/message/send/{chatUuid}")
    @SendTo("/topic/chat/{chatUuid}")
    public OutputMessageModel sendMessage(@Payload MessageModel messageModel,
                                          @DestinationVariable String chatUuid) {
        messageChatService.save(messageModel);
        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessageModel(messageModel.getSender(), chatUuid, messageModel.getContent(),
                time, OutputMessageModel.MessageType.CHAT);
    }
}

