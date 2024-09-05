package com.elice.project.ch1104.practice7.Entity;

import com.elice.project.ch1104.practice7.audit.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// BaseEntity를 상속할 수 있도록 코드를 작성해 보세요.
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contact extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

//    public ContactResponseDto toContactReponseDto() {
//        ContactResponseDto contactResponseDto = new ContactResponseDto(contactId, name, phoneNumber, email);
//        return contactResponseDto;
//    }
}