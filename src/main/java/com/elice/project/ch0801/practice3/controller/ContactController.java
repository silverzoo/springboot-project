//package com.elice.project.ch0801.practice3.controller;
//
//import com.elice.project.ch0801.practice3.entity.Contact;
//import com.elice.project.ch0801.practice3.entity.ContactPostDto;
//import com.elice.project.ch0801.practice3.entity.ContactResponseDto;
//import com.elice.project.ch0801.practice3.service.ContactService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
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
//    @PostMapping
//    public ResponseEntity<ContactResponseDto> postContact(@RequestBody ContactPostDto contactPostDto) {
//        // DTO를 Entity로 변환
//        Contact contact = contactPostDto.toContactEntity();
//        // Contact를 저장
//        Contact savedContact = contactService.createContact(contact);
//        // 저장된 Contact를 DTO로 변환
//        ContactResponseDto contactResponseDto = savedContact.toContactReponseDto();
//        // 응답 반환
//        return new ResponseEntity<>(contactResponseDto, HttpStatus.CREATED);
//    }
//}
