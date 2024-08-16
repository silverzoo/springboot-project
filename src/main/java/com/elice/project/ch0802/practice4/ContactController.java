package com.elice.project.ch0802.practice4;

import com.elice.project.ch0801.practice4.entity.ContactResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("/contacts")
public class ContactController {

//    private final ContactService contactService;
//
//    @Autowired
//    public ContactController(ContactService contactService) {
//        this.contactService = contactService;
//    }
//
    // POST 요청 핸들러에 전달되는 매개변수 ContactPostDto에 @Validated 애너테이션을 적용
    @PostMapping
    public ResponseEntity<ContactResponseDto> postContact(@Validated @RequestBody ContactPostDto contactPostDto) {
//        Contact contact = contactPostDto.toEntity();
//        Contact newContact = contactService.createContact(contact);
//
//        ContactResponseDto contactResponseDto = newContact.toContactReponseDto();
        return new ResponseEntity<>(/*contactResponseDto,*/ HttpStatus.CREATED);
    }
//    @GetMapping("/{contactId}")
//    public ResponseEntity<Contact> getContact(@PathVariable("contactId") long contactId) {
//        Contact contact = contactService.findContact(contactId);
//        if (contact == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(contact, HttpStatus.OK);
//    }
//
//    @GetMapping("/name-search")
//    public List<Contact> getContactByStartingWith(@RequestParam(name = "name") String name) {
//        return contactService.getContactByNameStartingWith(name);
//    }
//
//    @GetMapping("/email-search")
//    public List<Contact> getContactByEmailEndingWith(@RequestParam(name = "email") String email) {
//        return contactService.getContactByEmailEndingWith(email);
//    }
//
//
//    @GetMapping
//    public ResponseEntity<List<Contact>> getContacts(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "size",  defaultValue = "10") int size) {
//        Page<Contact> pageContacts = contactService.findContacts(page, size);
//        List<Contact> contacts = pageContacts.getContent();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Total-Element", String.valueOf(pageContacts.getTotalElements()));
//        headers.add("Total-Pages", String.valueOf(pageContacts.getTotalPages()));
//        headers.add("Current-Page", String.valueOf(pageContacts.getNumber() + 1));
//        headers.add("Page-Size", String.valueOf(pageContacts.getSize()));
//
//        if (contacts.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<>(contacts, headers, HttpStatus.OK);
//    }


//
//    @PutMapping("/{contactId}")
//    public ResponseEntity<Contact> updateContact(@PathVariable("contactId") long contactId, @RequestBody Contact contact) {
//        contact.setContactId(contactId);
//        Contact updatedContact = contactService.updateContact(contact);
//        return new ResponseEntity<>(updatedContact, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{contactId}")
//    public ResponseEntity<Void> deleteContact(@PathVariable("contactId") long contactId) {
//        contactService.deleteContact(contactId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
