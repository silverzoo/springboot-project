package com.elice.project.ch0603.practice4;

import jakarta.annotation.*;
import org.springframework.stereotype.*;

// TODO: Bean 설정
@Service
public class UserService {
    // TODO: 생성 메서드 구현
    @PostConstruct
    public void init() {
        System.out.println("UserService Bean 생성!");
    }

    // TODO: 파괴 메서드 구현
    @PreDestroy
    public void destroy() {
        System.out.println("UserService Bean 파괴!");
    }
}