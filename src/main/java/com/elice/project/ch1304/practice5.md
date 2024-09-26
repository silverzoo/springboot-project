```java
package com.elice.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.elice.member.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        // 지시사항을 참고하여 코드를 작성해 보세요.
        System.out.println("JWTAuthenticationFilter_attemptAuthentication 동작");

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Member member = objectMapper.readValue(request.getInputStream(), Member.class);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(member.getName(), member.getPassword());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);

            System.out.println("사용자 인증 완료");
            return authentication;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
```