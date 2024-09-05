package com.elice.project.ch1104.practice5;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> findContacts() {
        return contactRepository.findAll();
    }

    // 지시사항에 따라 코드를 작성해 보세요.
    public Page<com.elice.project.ch1104.practice5.Contact> findContacts(int page, int size) {
        return contactRepository.findAll(PageRequest.of(page-1, size, Sort.by("contactId").descending()));
    }

}