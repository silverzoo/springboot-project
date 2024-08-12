package com.elice.project.ch0801.practice1;


//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// 지시 사항에 따라 코드를 작성해 보세요.
//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contact  {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;
    private String name;
    private String phoneNumber;
    private String email;

    //lombok 어노테이션을 사용하면 아래 모두 생략 가능
    // public Contact() {
    // }

    // public Contact(String name, String phoneNumber, String email) {
    //     this.name = name;
    //     this.phoneNumber = phoneNumber;
    //     this.email = email;
    // }

    // public Long getContactId() {
    //     return contactId;
    // }

    // public void setContactId(Long contactId) {
    //     this.contactId = contactId;
    // }

    // public String getName() {
    //     return name;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public String getPhoneNumber() {
    //     return phoneNumber;
    // }

    // public void setPhoneNumber(String phoneNumber) {
    //     this.phoneNumber = phoneNumber;
    // }

    // public String getEmail() {
    //     return email;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

    // 이 메서드는 테스트를 위한 것으로 변경하지 않습니다.
//    public ContactResponseDto toContactReponseDto() {
//        ContactResponseDto contactResponseDto = new ContactResponseDto(contactId, name, phoneNumber, email);
//        return contactResponseDto;
//    }
}