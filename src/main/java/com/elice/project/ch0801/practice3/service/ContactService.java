//package com.elice.project.ch0801.practice3.service;
//
//import com.elice.project.ch0801.practice3.entity.Contact;
//import com.elice.project.ch0801.practice3.repository.JdbcContactRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ContactService {
//
//    private final JdbcContactRepository contactRepository;
//
//    public ContactService(JdbcContactRepository contactRepository) {
//        this.contactRepository = contactRepository;
//    }
//
//    public List<Contact> findContacts() {
//        return contactRepository.findAll();
//    }
//
//    public Contact findContact(long contactId) {
//        return contactRepository.findById(contactId)
//                .orElseThrow(() -> new RuntimeException());
//
//    }
//
//    public Contact createContact(Contact contact) {
//        return contactRepository.save(contact);
//    }
//
//    public Contact updateContact(Contact contact) {
//        Contact findContact = contactRepository.findById(contact.getContactId())
//                .orElseThrow(() -> new RuntimeException());
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
//        return contactRepository.save(findContact);
//    }
//
//    public void deleteContact(long contactId) {
//        Contact contact = contactRepository.findById(contactId)
//                .orElseThrow(() -> new RuntimeException());
//
//        contactRepository.delete(contact);
//    }
//}
