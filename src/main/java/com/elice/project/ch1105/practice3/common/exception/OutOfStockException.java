package com.elice.project.ch1105.practice3.common.exception;

import com.elice.project.ch1105.practice3.common.enums.ErrorCode;
import lombok.Getter;
/**
 * [지시사항 1]
 * OutOfStockException 클래스 작성
 * 1. ErrorCode OUT_OF_STOCK을 활용
 * 2. RuntimeException 자식 클래스인 RootException을 상속받는다.
 */
@Getter
public class OutOfStockException extends RootException {
    private ErrorCode errorCode;

    public OutOfStockException() {
        super(ErrorCode.OUT_OF_STOCK.getDetailMessage());
        this.errorCode = ErrorCode.OUT_OF_STOCK;
    }
}

