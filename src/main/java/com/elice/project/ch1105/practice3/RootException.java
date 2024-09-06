package com.elice.project.ch1105.practice3;

import lombok.Getter;

@Getter
public class RootException extends RuntimeException {
    private boolean isSuccess;
    private String detailMessage;

    public RootException(String message) {
        super(message);
        this.isSuccess = false;
        this.detailMessage = message;
    }
}