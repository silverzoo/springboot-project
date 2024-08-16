package com.elice.project.ch0802.practice3;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

// @Component
public class UserInfoValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserInfoForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserInfoForm userInfo = (UserInfoForm) target;

        if (!StringUtils.hasText(userInfo.getName())) {
            errors.rejectValue("name", "required");
        }

        if (userInfo.getAge() == null || userInfo.getAge() < 19 ) {
            errors.rejectValue("age", "min", new Object[]{19}, null);
        }

        if (!userInfo.isMembership()) {
            errors.rejectValue("membership", "membership");
        }
    }
}