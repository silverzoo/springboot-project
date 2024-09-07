package com.elice.project.ch1105.practice3.book.controller;

import com.elice.project.ch1105.practice3.book.model.BookRequest;
import com.elice.project.ch1105.practice3.book.model.BookResponse;
import com.elice.project.ch1105.practice3.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class BookController {
    private final BookService bookService;

    /**
     * 모든 책 조회 API
     */
    @GetMapping("/book/list")
    public List<BookResponse> getBookList() {
        return bookService.getBookList();
    }

    /**
     * 책 등록 API
     */
    @PostMapping("/book")
    public BookResponse saveBook(@RequestBody BookRequest bookRequest) {
        return bookService.save(bookRequest);
    }

    /**
     * 책 수량 수정 API
     */
    @PutMapping("/book/{id}")
    public BookResponse updateBook(@PathVariable Long id, @RequestBody BookRequest bookRequest) {
        return bookService.updateBook(id, bookRequest);
    }
}
