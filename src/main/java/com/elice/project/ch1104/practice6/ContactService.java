package com.elice.project.ch1104.practice6;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getContactByNameStartingWith(String name) {
        return contactRepository.findByNameStartingWith(name);
    }

    public List<Contact> getContactByEmailEndingWith(String email) {
        return contactRepository.findByEmailEndingWith(email);
    }

}