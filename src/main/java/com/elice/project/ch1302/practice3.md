```java
package com.elice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ProjectConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.withUsername("elice")
                .password("12345")
                .roles("ADMIN")
                .build();

        UserDetails user2 = User.withUsername("elicer")
                .password("12345")
                .roles("MANAGER")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        http
                .httpBasic()
                .and()
                // 지시사항을 참고하여 코드를 작성해 보세요
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/hello").hasRole("ADMIN")
                        .requestMatchers("/elice-cloud-track").hasRole("MANAGER")
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}
```
