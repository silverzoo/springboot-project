package com.elice.project.ch0801.practice3.entity;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContactPostDto {

    private String name;
    private String phoneNumber;
    private String email;

    // DTO를 Entity로 변환
    public Contact toContactEntity() {
        Contact contact = new Contact();
        contact.setName(this.name);
        contact.setPhoneNumber(this.phoneNumber);
        contact.setEmail(this.email);
        return contact;
    }
}
