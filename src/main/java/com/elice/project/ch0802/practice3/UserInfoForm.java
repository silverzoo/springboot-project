package com.elice.project.ch0802.practice3;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class UserInfoForm {

    // 지시사항을 참고하여 코드를 작성해 보세요.
    @NotBlank(message = "이름은 공백일 수 없습니다.")
    private String name;

    @Min(value = 19, message = "나이는 19세 이상이어야 합니다.")
    private Integer age;

    @AssertTrue(message = "멤버십 회원이어야 합니다.")
    private boolean membership;
}
