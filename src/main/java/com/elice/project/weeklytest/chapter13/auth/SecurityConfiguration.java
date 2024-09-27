package com.elice.project.weeklytest.chapter13.auth;

import com.elice.project.weeklytest.chapter13.member.entity.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

// 지시사항을 참고하여 코드를 작성해 보세요.
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    // 지시사항을 참고하여 코드를 작성해 보세요.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(formLogin -> formLogin
                        .loginPage("/login-form")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/subjects", true)
                        .failureUrl("/login-form?error")
                        .usernameParameter("user")
                        .passwordParameter("password")
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login", "/subjects").permitAll()
                        .requestMatchers("/add", "/subjects/add").hasRole(Member.Role.ADMIN.name())

                        //허용 유저가 여러명일 경우
                        //.requestMatchers("/my-page/**").hasAnyRole(Member.Role.USER.name(), Member.Role.ADMIN.name())
                        .anyRequest().authenticated()
                )
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .accessDeniedHandler(accessDeniedHandler()) // 접근 권한이 없는 경우 처리
                );

        return http.build();

    }

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

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    private AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> {
            response.sendRedirect("/access-denied");
        };
    }
}