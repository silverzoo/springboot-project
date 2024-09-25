```java
package com.elice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public TextEncryptor textEncryptor() {
        // 지시사항을 참고하여 코드를 작성해보세요
        String password = "ElicePassword";
        String salt = KeyGenerators.string().generateKey();

        return Encryptors.text(password, salt);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .formLogin().disable()
                .httpBasic().disable();

        return http.build();
    }

}
```
