package com.elice.project.ch1104.practice7.Repository;

import com.elice.project.ch1104.practice7.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query(value = "SELECT * FROM contact WHERE name LIKE ?1%", nativeQuery = true)
    List<Contact> findByNameStartingWith(String name);

    @Query(value = "SELECT * FROM contact WHERE email LIKE %?1", nativeQuery = true)
    List<Contact> findByEmailEndingWith(String email);
}