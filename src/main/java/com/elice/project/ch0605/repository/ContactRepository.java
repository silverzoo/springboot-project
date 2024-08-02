package com.elice.project.ch0605.repository;


import com.elice.project.ch0605.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
