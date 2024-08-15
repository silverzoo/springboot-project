package com.elice.project.ch0804.practice5;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// 지시사항을 참고하여 코드를 작성해 보세요.
@Aspect
@Component
public class ContactLoggingAspect {

    // 테스트를 위한 코드입니다. 수정하지 말아주세요.
    private Logger log = LoggerFactory.getLogger(ContactLoggingAspect.class);

    public void setLogger(Logger logger) {
        this.log = logger;
    }
    // 여기까지

    // com.elice.service.ContactService 패키지 내 모든 메서드 대상
    @Pointcut("execution(* com.elice.project.ch0804.practice5.ContactService.*(..))")
    public void targetMethods() {}

    // ContactNotFoundException이 발생했을 때 로그를 남기기 위한 어드바이스
    @AfterThrowing(pointcut = "targetMethods()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, ContactNotFoundException e) {
        String methodName = joinPoint.getSignature().toShortString();
        log.error("[예외 발생] 메서드: {}, 에러 메시지: {}", methodName, e.getMessage());
    }

}