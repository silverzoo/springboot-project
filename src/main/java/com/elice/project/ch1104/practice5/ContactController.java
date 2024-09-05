package com.elice.project.ch1104.practice5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }


    // 지시사항에 따라 코드를 작성해 보세요.
    @GetMapping
    public ResponseEntity<List<Contact>> getContacts(@RequestParam(name="page", defaultValue="1") int page, @RequestParam(name="size", defaultValue="10") int size) {
        Page<Contact> pageContacts = contactService.findContacts(page, size);
        List<Contact> contacts = pageContacts.getContent();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Element", String.valueOf(pageContacts.getTotalElements()));
        headers.add("Total-Pages", String.valueOf(pageContacts.getTotalPages()));
        headers.add("Current-Page", String.valueOf(pageContacts.getNumber()+1));
        headers.add("Page-size", String.valueOf(pageContacts.getSize()));

        if(contacts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contacts, headers, HttpStatus.OK);
    }

}