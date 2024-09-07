package com.elice.project.ch1105.practice3.repository;

import com.elice.project.ch1105.practice3.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByBookCode(String bookCode);
}
