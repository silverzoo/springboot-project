package com.elice.project.weeklytest.chapter12.exception;

import lombok.Getter;

public class ServiceLogicException extends RuntimeException {

    @Getter
    private ExceptionCode exceptionCode;

    public ServiceLogicException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }
}
