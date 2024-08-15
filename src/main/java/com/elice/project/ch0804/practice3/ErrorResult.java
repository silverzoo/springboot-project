package com.elice.project.ch0804.practice3;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorResult {

    private List<FieldError> fieldErrors;

    @Getter
    @AllArgsConstructor
    public static class FieldError {
        // 지시사항을 참고하여 코드를 작성해 보세요.
        public String fieldName;
        public Object rejectedValue;
        public String message;
    }
}
