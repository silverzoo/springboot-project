package com.elice.project.weeklytest.chapter12.aop;

import com.elice.project.weeklytest.chapter12.entity.Subject;
import com.elice.project.weeklytest.chapter12.entity.SubjectPostDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


@Aspect
@Component
public class SubjectLoggingAspect {

    private static Logger log = LoggerFactory.getLogger(SubjectLoggingAspect.class);

    @Pointcut("execution(* com.elice.project.weeklytest.chapter12.controller.SubjectController.*(..))")
    public void targetMethod() {
    }

    @Pointcut("execution(* com.elice.project.weeklytest.chapter12.controller.SubjectController.postSubject(..))")
    private void postSubjectMethod() {
    }

    // 지시사항을 참고하여 코드를 작성해 보세요.
    @Pointcut("execution(* com.elice.project.weeklytest.chapter12.controller.SubjectController.getSubject(..))")
    public void getSubjectMethod() {
    }

    // 지시사항을 참고하여 코드를 작성해 보세요.
    @Before("getSubjectMethod()")
    public void logBeforeGetSubject(JoinPoint joinPoint) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        for (int i = 0; i < method.getParameters().length; i++) {
            Annotation[] annotations = method.getParameters()[i].getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof PathVariable) {

                    Long subjectId = (Long) joinPoint.getArgs()[i];
                    log.info("과목 조회 요청: 과목 ID {}", subjectId);
                    return;

                }
            }
        }
    }

    @Before("targetMethod()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("[메서드 호출 전] 호출 메서드: {}", joinPoint.getSignature().getName());
    }

    @After("targetMethod()")
    public void logAfter(JoinPoint joinPoint) {
        log.info("[메서드 호출 후] 호출 메서드: {}", joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "targetMethod()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        log.error("[예외 발생] 메서드: {}, 에러 메시지: {}", joinPoint.getSignature().getName(), ex.getMessage());
    }

    @Before("postSubjectMethod()")
    public void logPostSubject(JoinPoint joinPoint) {
        SubjectPostDto subjectDto = (SubjectPostDto) joinPoint.getArgs()[0];
        String name = subjectDto.getName();
        log.debug("새 과목 생성 요청: {}", name);
    }

    @AfterReturning(pointcut = "postSubjectMethod()", returning = "responseEntity")
    public void logAfterPostSubject(JoinPoint joinPoint, ResponseEntity responseEntity) {

        if (responseEntity != null && responseEntity.getBody() instanceof Subject) {
            Subject newSubject = (Subject) responseEntity.getBody();
            Long subjectId = newSubject.getSubjectId();
            log.info("과목 생성 성공: 과목 ID {}", subjectId);
        }
    }
}