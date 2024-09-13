package com.elice.project.weeklytest.chapter12.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ExceptionCode {
    SUBJECT_NOT_FOUND(404, "존재하지 않는 과목입니다."),
    SUBJECT_EXISTS(409, "이미 존재하는 과목입니다.");

    @Getter
    private int status;

    @Getter
    private String message;
}
