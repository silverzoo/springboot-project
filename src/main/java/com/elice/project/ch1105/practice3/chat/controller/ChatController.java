package com.elice.project.ch1105.practice3.chat.controller;

import com.elice.project.ch1105.practice3.chat.model.ChatCreateRequest;
import com.elice.project.ch1105.practice3.chat.model.ChatCreateResponse;
import com.elice.project.ch1105.practice3.chat.model.ChatInfoResponse;
import com.elice.project.ch1105.practice3.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/chat")
@RestController
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/list")
    public List<ChatInfoResponse> getChats() {
        return chatService.getChats();
    }

    @GetMapping
    public ChatInfoResponse getChat(@Validated @RequestParam String chatUuid) {
        return chatService.getChat(chatUuid);
    }

    @PostMapping
    public ChatCreateResponse makeChat(@RequestBody ChatCreateRequest request) {
        return chatService.makeChat(request.getChatUuid(), request.getChatTitle());
    }

    @DeleteMapping
    public void deleteAllChat() {
        chatService.deleteAllChat();
    }

}

