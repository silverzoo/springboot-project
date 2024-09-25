```java
package com.elice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.authorization.AuthorityAuthorizationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;

@Configuration
public class ProjectConfig {

    // 사용자 정보를 메모리에 저장하는 UserDetailsService 빈 정의
    @Bean
    public UserDetailsService userDetailsService() {
        var manager = new InMemoryUserDetailsManager();




        // 지시사항을 참고하여 코드를 작성해 보세요

        // 'read' 권한만 가진 사용자 생성
        var user1 = User.withUsername("elice")
                .password("12345")
                .authorities("read")
                .build();


        // 'read', 'write', 'delete' 권한을 가진 사용자 생성
        var user2 = User.withUsername("elicer")
                .password("12345")
                .authorities("read", "write", "delete")
                .build();

        manager.createUser(user1);
        manager.createUser(user2);

        return manager;
    }

    // 비밀번호 인코더 빈 정의 (실제 운영 환경에서는 사용하지 말 것)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    // Spring Security 필터 체인 구성
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                .anyRequest()
                .access(authorizationManager());

        return http.build();
    }

    // 커스텀 권한 부여 관리자 정의
    @Bean
    public AuthorizationManager<RequestAuthorizationContext> authorizationManager() {
        return (authentication, requestContext) -> {
            // GET 요청에 대해서는 'read' 권한만 필요
            if ("GET".equals(requestContext.getRequest().getMethod())) {
                return new AuthorizationDecision(
                        AuthorityAuthorizationManager.hasAuthority("read")
                                .check(authentication, requestContext)
                                .isGranted()
                );
            }

            // POST 요청에 대해서는 'write' 권한 필요
            if ("POST".equals(requestContext.getRequest().getMethod())) {
                return new AuthorizationDecision(
                        AuthorityAuthorizationManager.hasAuthority("write")
                                .check(authentication, requestContext)
                                .isGranted()
                );
            }

            // 기타 요청은 거부
            return new AuthorizationDecision(false);
        };
    }
}
```
