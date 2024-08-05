//package com.elice.project.ch0605.controller;
//
//import com.elice.project.ch0605.service.ContactService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequestMapping("/contacts")
//public class ContactController {
//
//    private final ContactService contactService;
//
//    @Autowired
//    public ContactController(ContactService contactService) {
//        this.contactService = contactService;
//    }
//
//    // 특정 연락처 조회
//    @GetMapping("/{contactId}")
//    public ResponseEntity<Contact> findContact(@PathVariable("contactId") long contactId) {
//        Contact data = contactService.findContact(contactId);
//        if(data == null) return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(data, HttpStatus.OK);
//    }
//
//    // 모든 연락처 조회
//    @GetMapping()
//    public ResponseEntity<List<Contact>> findContacts() {
//        List<Contact> dataList = contactService.findContacts();
//        if(dataList.isEmpty()) return new ResponseEntity<>(dataList, HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(dataList, HttpStatus.OK);
//    }
//
//    // 연락처 등록
//    @PostMapping
//    public ResponseEntity<Contact> postContact(@RequestBody Contact contact) {
//        Contact data = contactService.createContact(contact);
//        return new ResponseEntity<>(data, HttpStatus.CREATED);
//    }
//
//
//    // 연락처 수정
//    @PutMapping("/{contactId}")
//    public ResponseEntity<Contact> updateContact(@PathVariable("contactId") long contactId, @RequestBody Contact contact) {
//        contact.setContactId(contactId);
//        Contact updateData = contactService.updateContact(contact);
//        return new ResponseEntity<>(updateData, HttpStatus.OK);
//    }
//
//    // 연락처 삭제
//    @DeleteMapping("/{contactId}")
//    public ResponseEntity<Void> deleteContact(@PathVariable("contactId") long contactId) {
//
//        contactService.deleteContact(contactId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//}