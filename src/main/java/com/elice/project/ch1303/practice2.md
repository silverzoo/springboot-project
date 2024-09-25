```java
package com.elice.filters;


import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;


@Component
public class AuthenticationLoggingFilter extends OncePerRequestFilter {


    private final Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());



    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // 지시사항에 따라 코드를 작성해 보세요.
        String requestId = request.getHeader("Request-Id");
        logger.info("Successfully authenticated request with id " + requestId);
        filterChain.doFilter(request, response);
    }
}
```
