package com.elice.project.ch1105.practice3.book.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookCode;
    private String name;
    private long quantity;

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    public Book(String name, long quantity) {
        this.bookCode = "BOOK-"+ UUID.randomUUID();
        this.name = name;
        this.quantity = quantity;
    }

    public void update(String bookName, long quantity) {
        this.name = bookName;
        this.quantity = quantity;
    }
}
