```java
package com.elice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;



// 지시사항을 참고하여 코드를 작성해 보세요.   
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // 지시사항을 참고하여 코드를 작성해 보세요.   
        http
                .csrf().disable()  // CSRF 보호 비활성화 (원하는 경우 활성화 가능)
                .authorizeRequests()
                .anyRequest().permitAll()  // 모든 요청을 인증 없이 허용
                .and()
                .formLogin().disable()  // 기본 로그인 폼 비활성화
                .httpBasic().disable(); // HTTP 기본 인증 비활성화

        return http.build();
    }
}
```
