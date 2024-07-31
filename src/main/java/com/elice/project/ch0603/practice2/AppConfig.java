package com.elice.project.ch0603.practice2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 지시사항을 참고하여 코드를 작성해 보세요.
@Configuration
class AppConfig {

    @Bean
    public UserService userService() {
        return new UserService();
    }
}

