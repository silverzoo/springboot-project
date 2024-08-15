package com.elice.project.ch0804.practice2;

import org.springframework.stereotype.Service;

@Service
public class ContactService {

//    private final ContactRepository contactRepository;
//
//    private static final Logger log = LoggerFactory.getLogger(ContactService.class);
//
//    public ContactService(ContactRepository contactRepository) {
//        this.contactRepository = contactRepository;
//    }
//
//    public Page<Contact> findContacts(int page, int size) {
//        log.info("페이지별 연락처 조회: 페이지 {}, 크기: {}", page, size);
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
//                .orElseThrow(() -> new RuntimeException());
//    }
//
//    @Transactional
//    public Contact createContact(Contact contact) {
//        log.debug("새로운 연락처 생성: {}", contact.getName());
//
//        Contact savedContact = contactRepository.save(contact);
//
//        return savedContact;
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
//
//        return contactRepository.save(findContact);
//    }
//
//    public void deleteContact(long contactId) {
//
//        Contact contact = contactRepository.findById(contactId)
//                .orElseThrow(() -> new RuntimeException());
//
//        contactRepository.delete(contact);
//    }
}

