package com.elice.project.ch1204.practice3;

import com.elice.project.ch1104.practice7.Entity.Contact;
import com.elice.project.ch1104.practice7.Repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    // 지시사항을 참고하여 코드를 작성해 보세요.
    private Logger log = LoggerFactory.getLogger(ContactService.class);

    public void setLogger(Logger logger) {
        this.log = logger;
    }

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Page<Contact> findContacts(int page, int size) {
        // 지시사항을 참고하여 코드를 작성해 보세요.
        log.info("페이지별 연락처 조회: 페이지 {}, 크기: {}", page, size);

        return contactRepository.findAll(PageRequest.of(page - 1, size, Sort.by("contactId").descending()));
    }

    @Transactional
    public Contact createContact(Contact contact) {
        // 지시사항을 참고하여 코드를 작성해 보세요.
        log.debug("새로운 연락처 생성: {}", contact.getName());

        Contact savedContact = contactRepository.save(contact);

        if (true) {
            // 지시사항을 참고하여 코드를 작성해 보세요.
            log.error("연락처 생성 중 예외 발생, 트랜잭션 롤백");

            throw new RuntimeException("롤백 발생!");
        }

        return savedContact;
    }
}