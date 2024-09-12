package com.elice.project.ch1204.practice6;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


// implementation 'org.springframework.boot:spring-boot-starter-aop:3.2.0' 필요
@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // com.elice.service 패키지의 모든 메서드에서 실행
    @Around("execution(* com.elice.service.*.*(..))")
    public Object logServiceMethods(ProceedingJoinPoint joinPoint) throws Throwable {

        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        logger.info("------------------------------------------------------------------");
        logger.info("메소드 접근 : {}() in class: {}", methodName, className);

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        logger.info("메소드 탈출: {}() in class: {}. Execution time: {} ms", methodName, className, (endTime - startTime));
        logger.info("------------------------------------------------------------------");

        return result;

    }
}