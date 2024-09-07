package com.elice.project.ch1105.practice3.chat.service;

import com.elice.project.ch1105.practice3.chat.domain.Chat;
import com.elice.project.ch1105.practice3.chat.model.ChatCreateResponse;
import com.elice.project.ch1105.practice3.chat.model.ChatInfoResponse;
import com.elice.project.ch1105.practice3.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class ChatService {

    private final ChatRepository chatRepository;

    @Transactional(readOnly = true)
    public List<ChatInfoResponse> getChats() {
        List<Chat> chatList = chatRepository.findAll();

        List<ChatInfoResponse> chatInfoResponses = new ArrayList<>();
        chatList.stream().forEach(chat ->
                chatInfoResponses.add(new ChatInfoResponse(chat.getChatUuid(), chat.getChatTitle())));

        return chatInfoResponses;
    }

    public ChatInfoResponse getChat(String chatUuid) {
        Chat chat = chatRepository.findByChatUuid(chatUuid);
        return new ChatInfoResponse(chat.getChatUuid(), chat.getChatTitle());
    }

    public ChatCreateResponse makeChat(String chatUuid, String chatTitle) {
        Chat existChat = chatRepository.findByChatUuid(chatUuid);
        if (Objects.nonNull(existChat)) {
            //refactoring to globalExceptionHandler
            return null;
        }

        Chat chat = new Chat(chatUuid, chatTitle);
        chatRepository.save(chat);
        return ChatCreateResponse.from(true, "채팅방을 생성하였습니다.");
    }

    @Transactional
    public void deleteAllChat() {
        chatRepository.deleteAll();
    }
}

