package com.elice.project.ch1105.practice3;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String bookCode;
    private String bookName;
    private long quantity;

    public Order(String bookCode, String bookName, long quantity) {
        this.uuid = "ORDER-"+ UUID.randomUUID();
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.quantity = quantity;
    }
}
