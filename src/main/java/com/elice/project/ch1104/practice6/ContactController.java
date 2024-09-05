package com.elice.project.ch1104.practice6;

import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/name-search")
    public List<Contact> getContactByStartingWith(@RequestParam(name = "name") String name) {
        return contactService.getContactByNameStartingWith(name);
    }

    @GetMapping("/email-search")
    public List<Contact> getContactByEmailEndingWith(@RequestParam(name = "email") String email) {
        return contactService.getContactByEmailEndingWith(email);
    }


}