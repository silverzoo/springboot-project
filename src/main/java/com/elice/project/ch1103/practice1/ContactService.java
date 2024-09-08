package com.elice.project.ch1103.practice1;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Transactional
    public Contact createContact(Contact contact) {

        Contact savedContact = contactRepository.save(contact);

        // 위와 같은 예외가 발생했을 때, 앞에서 저장한 객체가 저장되지 않고 롤백되도록 createContact 메서드에 트랜잭션을 적용해 봅니다.
        throw new RuntimeException ("롤백 발생!");

        //return savedContact;
    }

}