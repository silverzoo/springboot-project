package com.elice.project.ch1105.practice3;

import lombok.Getter;

@Getter
public enum ErrorCode {

    OUT_OF_STOCK(400, "OutOfStockException", "책 재고가 부족합니다."),
    DATA_NOT_FOUND(400, "DataNotFoundException", "데이터를 찾을 수 없습니다.");

    private final int status;
    private final String message;
    private final String detailMessage;

    ErrorCode(int status, String message, String detailMessage) {
        this.status = status;
        this.message = message;
        this.detailMessage = detailMessage;
    }
}
