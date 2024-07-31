package com.elice.project.ch0603.practice1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class FactorialTimeAspect {
    @Pointcut("execution(public void com.elice.factorial..factorial(..))")
    private void targetMethod() {};


    @Around("targetMethod()")
    public Object calculateTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();

        try {
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long endTime = System.nanoTime();
            System.out.printf("호출 클래스: %s\n", joinPoint.getTarget().getClass().getSimpleName());
            System.out.printf("실행 시간: %d ns\n", (endTime - startTime));
        }
    }
}