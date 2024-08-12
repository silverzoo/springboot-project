//package com.elice.project.ch0801.practice4.controller;
//
//import com.elice.project.ch0801.practice4.entity.Contact;
//import com.elice.project.ch0801.practice4.entity.ContactPostDto;
//import com.elice.project.ch0801.practice4.entity.ContactResponseDto;
//import com.elice.project.ch0801.practice4.mapper.ContactMapper;
//import com.elice.project.ch0801.practice4.service.ContactService;
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
//    private final ContactMapper contactMapper;
//
//    @Autowired
//    public ContactController(ContactService contactService, ContactMapper contactMapper) {
//        this.contactService = contactService;
//        this.contactMapper = contactMapper;
//    }
//
//    // 지시사항에 맞게 코드를 수정해 주세요.
//    @PostMapping
//    public ResponseEntity<ContactResponseDto> postContact(@RequestBody ContactPostDto contactPostDto) {
////        Contact contact = contactPostDto.toEntity();
////        ContactResponseDto contactResponseDto = newContact.toContactReponseDto();
//
//        Contact contact = contactMapper.toContact(contactPostDto);
//        Contact newContact = contactService.createContact(contact);
//
//        ContactResponseDto contactResponseDto = contactMapper.toResponseDto(newContact);
//        return new ResponseEntity<>(contactResponseDto, HttpStatus.CREATED);
//    }
//}