package com.elice.project.ch1105.practice3.chat.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String chatUuid;

    private String chatTitle;

    @OneToMany(mappedBy = "chat")
    private Set<Message> messages = new HashSet<>();

    public Chat(String chatUuid, String chatTitle) {
        this.chatUuid = chatUuid;
        this.chatTitle = chatTitle;
    }
}
