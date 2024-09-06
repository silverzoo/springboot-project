package com.elice.project.ch1105.practice3;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    Chat findByChatUuid(String chatUuid);
}
