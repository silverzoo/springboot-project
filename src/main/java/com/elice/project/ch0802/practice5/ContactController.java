// 경로 변수와 쿼리 스트링에 대한 유효성 검사만 체크해보기
// @Validated : 클래스 레벨에 정의하여 모든 GET 핸들러 메서드들에 특정 유효성 검사가 적용될 수 있도록 함
// @Positive(양수만 허용)
// @NotBlank
// @Email
// @Min

package com.elice.project.ch0802.practice5;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/contacts")
// 지시사항을 참고하여 코드를 작성해 보세요.
@Validated
public class ContactController {
//
//    private final ContactService contactService;
//
//    @Autowired
//    public ContactController(ContactService contactService) {
//        this.contactService = contactService;
//    }
//
//    // 지시사항을 참고하여 코드를 작성해 보세요.
//    @GetMapping("/{contactId}")
//    public ResponseEntity<Contact> getContact(@PathVariable("contactId") @Positive long contactId) {
//        Contact contact = contactService.findContact(contactId);
//        if (contact == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(contact, HttpStatus.OK);
//    }
//
//    // 지시사항을 참고하여 코드를 작성해 보세요.
//    @GetMapping
//    public ResponseEntity<List<Contact>> getContacts(@RequestParam(name = "page", defaultValue = "1") @Min(1) int page,
//                                                     @RequestParam(name = "size",  defaultValue = "10") @Min(1) int size) {
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
//    // 지시사항을 참고하여 코드를 작성해 보세요.
//    @GetMapping("/name-search")
//    public List<Contact> getContactByStartingWith(@RequestParam(name = "name") @NotBlank String name) {
//        return contactService.getContactByNameStartingWith(name);
//    }
//
//    // 지시사항을 참고하여 코드를 작성해 보세요.
//    @GetMapping("/email-search")
//    public List<Contact> getContactByEmailEndingWith(@RequestParam(name = "email") @Email String email) {
//        return contactService.getContactByEmailEndingWith(email);
//    }
//
//    @PostMapping
//    public ResponseEntity<ContactResponseDto> postContact(@RequestBody @Validated ContactPostDto contactPostDto) {
//        Contact contact = contactPostDto.toEntity();
//        Contact newContact = contactService.createContact(contact);
//
//        ContactResponseDto contactResponseDto = newContact.toContactReponseDto();
//        return new ResponseEntity<>(contactResponseDto, HttpStatus.CREATED);
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