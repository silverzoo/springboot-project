package com.elice.project.ch1105.practice3;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByBookCode(String bookCode);
}
