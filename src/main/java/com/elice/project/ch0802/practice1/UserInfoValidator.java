package com.elice.project.ch0802.practice1;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

// 지시사항을 참고하여 코드를 작성해 보세요.
@Component
public class UserInfoValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserInfoForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserInfoForm userInfo = (UserInfoForm) target;

        // 지시사항을 참고하여 코드를 작성해 보세요.
        if(!StringUtils.hasText(userInfo.getName())) {
            errors.rejectValue("name","required");
        }

        if(userInfo.getAge() == null || userInfo.getAge() < 19) {
            errors.rejectValue("age", "min", new Object[]{19}, null);
        }

        //boolean 타입의 getter는 "is~" 이다.
        if (!userInfo.isMembership()) {
            errors.rejectValue("membership", "membership");
        }
    }
}