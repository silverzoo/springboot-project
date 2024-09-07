package com.elice.project.ch1105.practice3.book.service;

import com.elice.project.ch1105.practice3.book.domain.Book;
import com.elice.project.ch1105.practice3.book.model.BookRequest;
import com.elice.project.ch1105.practice3.book.model.BookResponse;
import com.elice.project.ch1105.practice3.common.exception.DataNotFoundException;
import com.elice.project.ch1105.practice3.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public List<BookResponse> getBookList() {
        return bookRepository.findAll().stream()
                .map(book -> new BookResponse(book.getBookCode(), book.getName(), book.getQuantity()))
                .collect(Collectors.toList());
    }

    @Transactional
    public BookResponse save(BookRequest bookRequest) {
        Book book = new Book(bookRequest.getBookName(), bookRequest.getQuantity());
        bookRepository.save(book);
        return new BookResponse(book.getName(), book.getQuantity());
    }

    @Transactional
    public BookResponse updateBook(Long bookId, BookRequest bookRequest) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new DataNotFoundException());

        //게시글을 수정합니다.
        book.update(bookRequest.getBookName(), bookRequest.getQuantity());

        return new BookResponse(book.getName(), book.getQuantity());
    }
}