package com.elice.project.ch1105.practice3.chat.service;

import com.elice.project.ch1105.practice3.chat.repository.ChatRepository;
import com.elice.project.ch1105.practice3.common.exception.DataNotFoundException;
import com.elice.project.ch1105.practice3.socket.model.MessageModel;
import com.elice.project.ch1105.practice3.chat.repository.MessageRepository;
import com.elice.project.ch1105.practice3.chat.domain.Chat;
import com.elice.project.ch1105.practice3.chat.domain.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class MessageChatService {
    private final MessageRepository messageRepository;
    private final ChatRepository chatRepository;


    public void save(MessageModel messageModel) {
        Chat chat = chatRepository.findByChatUuid(messageModel.getChatUuid());

        if (Objects.isNull(chat)) {
            throw new DataNotFoundException();
        }

        Message message = new Message(messageModel.getSender(), messageModel.getContent(), chat);
        messageRepository.save(message);

        log.info("{}가 전송한 '{}' 메시지가 저장되었습니다.", message.getSender(), message.getContent());
    }
}
