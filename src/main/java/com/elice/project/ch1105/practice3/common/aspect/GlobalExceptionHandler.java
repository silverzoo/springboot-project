package com.elice.project.ch1105.practice3.common.aspect;

import com.elice.project.ch1105.practice3.common.exception.OutOfStockException;
import com.elice.project.ch1105.practice3.common.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * [지시사항 2]
     * OutOfStockException 예외에 대한 ExceptionHandler 추가
     */
    @ExceptionHandler(OutOfStockException.class)
    public ErrorResponse handleInvalidPriceException(OutOfStockException ex) {
        log.error("Global-Handler[OutOfStockException] - {}", ex.getErrorCode().getDetailMessage());
        return new ErrorResponse(ex.getErrorCode());
    }


}


