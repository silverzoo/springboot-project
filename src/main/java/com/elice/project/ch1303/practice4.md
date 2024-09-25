```java
package com.elice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        //지시사항을 참고하여 코드를 작성해 보세요.
        http
                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
                    if (request.getRequestURI().startsWith("/api/")) {
                        config.setAllowedOrigins(List.of("http://elice.io"));
                        config.setAllowCredentials(true);
                    }
                    return config;
                }))
                .csrf().disable();

        return http.build();
    }
}
```
