package com.elice.project.ch0802.practice4;

import com.elice.project.ch0801.practice4.entity.Contact;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactPostDto {

    // 지시사항을 참고하여 코드를 작성해 보세요.
    @NotBlank(message = "이름은 필수입니다.")
    private String name;

    @NotBlank(message = "전화번호는 필수입니다.")
    @Pattern(regexp = "[0-9]+", message = "전화번호는 숫자만 포함해야 합니다.")
    @Size(min = 10, max = 15, message = "전화번호는 10자에서 15자 사이여야 합니다.")
    private String phoneNumber;

    @NotBlank(message = "이메일은 필수입니다.")
    @Email(message = "올바른 이메일 형식이어야 합니다.")
    private String email;

    public Contact toEntity() {
        Contact contact = new Contact(name, phoneNumber, email);
        return contact;
    }
}
