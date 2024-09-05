package com.elice.project.ch1104.practice5;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, updatable = true)
    private String phoneNumber;

    @Column(nullable = true, updatable = false)
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

