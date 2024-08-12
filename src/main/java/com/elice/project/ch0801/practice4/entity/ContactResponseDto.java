package com.elice.project.ch0801.practice4.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactResponseDto {

    private Long contactId;
    private String name;
    private String phoneNumber;
    private String email;

    public ContactResponseDto() {
    }


    public ContactResponseDto(Long contactId, String name, String phoneNumber, String email) {
        this.contactId = contactId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

}

