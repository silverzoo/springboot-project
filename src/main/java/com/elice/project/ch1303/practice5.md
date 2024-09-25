```java
package com.elice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.elice.member.Member;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests
                                .requestMatchers("/", "/login").permitAll()
                                .requestMatchers("/admin/**").hasRole(Member.Role.ADMIN.name())
                                .requestMatchers("/my-page/**").hasAnyRole(Member.Role.USER.name(), Member.Role.ADMIN.name())
                                .anyRequest().permitAll()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login-form")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/login-form?error")
                        .usernameParameter("name")
                        .passwordParameter("password")
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                )
                // 지시사항을 참고하여 코드를 작성해 보세요.
                .rememberMe(rememberMe -> rememberMe
                        .key("eliceRememberMeKey")
                        .tokenValiditySeconds(7 * 24 * 60 * 60) // 7일
                );

        return http.build();

    }

    // 테스트를 위한 코드입니다. 변경하지 않도록 합니다.
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("elicer")
                .password("1234")
                .roles("USER")
                .build();


        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("1234")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
```

```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 페이지</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 330px;
            padding: 15px;
            margin: auto;
        }

        .form-signin .form-control {
            position: relative;
            box-sizing: border-box;
            height: auto;
            padding: 10px;
            font-size: 16px;
        }

        .form-signin .form-control:focus {
            z-index: 2;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            margin-bottom: 10px;
        }

        .form-signin button {
            margin-top: 10px;
        }

        .field-error {
            border-color: #dc3545;
            color: #dc3545;
        }
    </style>
</head>
<body>

<div class="container">
    <form class="form-signin" action="/login" method="post">
        <h1 class="h3 mb-3 font-weight-normal text-center">로그인 페이지</h1>
        <hr/>
        <div class="row alert alert-danger center" role="alert" th:if="${param.error != null}">
            <div>로그인 인증에 실패했습니다.</div>
        </div>
        <input type="text" name="name" class="form-control" placeholder="Username" required>
        <input type="password" name="password" class="form-control" placeholder="Password" required>
                
        <!-- 지시사항을 참고하여 코드를 작성해 보세요. -->
        <!-- 로그인 기억하기 추가  --> 
        <div class="checkbox mb-3"> 
	        <label> 
		        <input type="checkbox" name="remember-me"> 로그인 기억하기 
	        </label> 
        </div>     
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
    </form>
</div>

</body>
</html>
```
