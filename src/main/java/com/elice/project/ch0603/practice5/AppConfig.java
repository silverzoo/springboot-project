package com.elice.project.ch0603.practice5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AppConfig {
    @Bean
    public UserService userService() {
        return new UserService();
    }
}