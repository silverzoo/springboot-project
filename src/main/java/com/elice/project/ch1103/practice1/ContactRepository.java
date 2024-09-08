package com.elice.project.ch1103.practice1;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByNameStartingWith(String name);

    List<Contact> findByEmailEndingWith(String email);

    List<Contact> findByName(String name);
}