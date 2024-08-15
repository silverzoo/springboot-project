package com.elice.project.ch0804.practice5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContactService {
//    흐름만 확인하기 위한 주석처리
//    private final ContactRepository contactRepository;
//
//    public ContactService(ContactRepository contactRepository) {
//        this.contactRepository = contactRepository;
//    }
//
//    public Page<Contact> findContacts(int page, int size) {
//        return contactRepository.findAll(PageRequest.of(page- 1, size, Sort.by("contactId").descending()));
//    }
//
//    public List<Contact> findContacts() {
//        return contactRepository.findAll();
//    }
//
//
//    public List<Contact> getContactByNameStartingWith(String name) {
//        return contactRepository.findByNameStartingWith(name);
//    }
//
//    public List<Contact> getContactByEmailEndingWith(String email) {
//        return contactRepository.findByEmailEndingWith(email);
//    }
//
//    public Contact findContact(long contactId) {
//        return contactRepository.findById(contactId)
//                .orElseThrow(() -> new ContactNotFoundException());
//    }
//
//    @Transactional
//    public Contact createContact(Contact contact) {
//        Contact savedContact = contactRepository.save(contact);
//
//        return savedContact;
//    }
//
//    public Contact updateContact(Contact contact) {
//        Contact findContact = contactRepository.findById(contact.getContactId())
//                .orElseThrow(() -> new ContactNotFoundException());
//
//        if (contact.getName() != null) {
//            findContact.setName(contact.getName());
//        }
//        if (contact.getPhoneNumber() != null) {
//            findContact.setPhoneNumber(contact.getPhoneNumber());
//        }
//        if (contact.getEmail() != null) {
//            findContact.setEmail(contact.getEmail());
//        }
//
//        return contactRepository.save(findContact);
//    }
//
//    public void deleteContact(long contactId) {
//
//        Contact contact = contactRepository.findById(contactId)
//                .orElseThrow(() -> new ContactNotFoundException());
//
//        contactRepository.delete(contact);
//    }
}

