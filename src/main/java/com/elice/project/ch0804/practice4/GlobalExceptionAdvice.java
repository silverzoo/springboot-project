package com.elice.project.ch0804.practice4;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

// 지시사항을 참고하여 코드를 작성해 보세요.
@RestControllerAdvice
public class GlobalExceptionAdvice {

    // 지시사항을 참고하여 코드를 작성해 보세요.
    @ExceptionHandler
    public ResponseEntity exceptionHandle(MethodArgumentNotValidException e) {
        // 여기서 FieldError 타입은 org.springframework.validation.FieldError 을 의미.
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        // FieldError 를 사용자 정의 ErrorResult.FieldError 로 매핑
        List<ErrorResult.FieldError> errorLogs
                = fieldErrors.stream()
                .map(error -> new ErrorResult.FieldError(
                        error.getField(),
                        error.getRejectedValue(),
                        error.getDefaultMessage()
                ))
                .collect(Collectors.toList());

        return new ResponseEntity<>(errorLogs, HttpStatus.BAD_REQUEST);
    }

}
