package com.elice.project.ch1105.practice3.book.model;

import lombok.Getter;

@Getter
public class BookResponse {
    private String bookCode;
    private String bookName;
    private long quantity;

    public BookResponse(String bookName, long quantity) {
        this.bookName = bookName;
        this.quantity = quantity;
    }

    public BookResponse(String bookCode, String bookName, long quantity) {
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.quantity = quantity;
    }
}
