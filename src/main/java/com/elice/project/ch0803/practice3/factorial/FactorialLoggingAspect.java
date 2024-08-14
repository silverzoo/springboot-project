package com.elice.project.ch0803.practice3.factorial;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Slf4j
public class FactorialLoggingAspect {

    // 지시사항에 따라 코드를 작성해 주세요.
    @Pointcut("execution(public void com.elice.project.ch0803.practice3.factorial..factorial(..))")
    private void targetMethod() {};

    @Before("targetMethod()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("[메서드 호출 전] 호출 클래스: " + joinPoint.getTarget().getClass().getSimpleName());
        log.info("[메서드 호출 전] 호출 메서드: " + joinPoint.getSignature().getName());
    }

    @After("targetMethod()")
    public void logAfter(JoinPoint joinPoint) {
        log.info("[메서드 호출 후] 호출 메서드: " + joinPoint.getSignature().getName());
    }
}
