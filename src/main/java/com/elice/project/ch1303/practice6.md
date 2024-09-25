```java
package com.elice.filters;

import com.elice.error.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestValidationFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String path = request.getRequestURI();

        // 지시 사항을 참고하여 아래 코드를 개선하세요.
        // if (path.startsWith("/api/")) {
        //     String requestId = request.getHeader("Request-Id");
        //     if (requestId == null || requestId.isBlank()) {
        //         response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        //         return;
        //     }
        // }

        if (path.startsWith("/api/")) {
            String requestId = request.getHeader("Request-Id");
            if (requestId == null || requestId.isBlank()) {

                var errorResponse = ErrorResponse
                        .builder()
                        .errorCode(400001)
                        .errorMessage("Request-Id header is missing or empty")
                        .build();


                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
```
