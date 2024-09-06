package com.elice.project.ch1105.practice3;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {
    private int status;
    private String message;
    private String detailMessage;

    public ErrorResponse(ErrorCode code) {
        this.status = code.getStatus();
        this.message = code.getMessage();
        this.detailMessage = code.getDetailMessage();
    }
}

