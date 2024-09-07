package com.elice.project.ch1105.practice3.chat.repository;

import com.elice.project.ch1105.practice3.chat.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
