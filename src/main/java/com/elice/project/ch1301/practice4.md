```java
package com.elice.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;

@Controller
public class VisitController {

    private static final int MAX_VISITS = 5;
    private static final String COOKIE_NAME = "visitHistory";
    
    
    private void setVisitHistoryCookie(HttpServletResponse response, LinkedList<String> visitHistory) {
        try {
            String encodedValue = URLEncoder.encode(String.join(",", visitHistory), StandardCharsets.UTF_8.toString());
            
            // 지시사항을 참고하여 코드를 작성해 보세요. 
            Cookie visitCookie = new Cookie(COOKIE_NAME, encodedValue);
            visitCookie.setPath("/");
            visitCookie.setMaxAge(60 * 60 * 24);
            response.addCookie(visitCookie);

        } catch (UnsupportedEncodingException e) {
        }
    }
    
    

    @GetMapping({"/blog", "/about", "/contact"})
    public String visitPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        String currentPage = request.getRequestURI();
        LinkedList<String> visitHistory = getVisitHistory(request);

        if (!visitHistory.contains(currentPage)) {
            visitHistory.addFirst(currentPage);
            if (visitHistory.size() > MAX_VISITS) {
                visitHistory.removeLast();
            }
        } else {
            visitHistory.remove(currentPage);
            visitHistory.addFirst(currentPage);
        }

        setVisitHistoryCookie(response, visitHistory);

        model.addAttribute("message", "현재 방문중인 페이지: " + currentPage);
        model.addAttribute("currentPage", currentPage);
        return "page";
    }

    @GetMapping("/")
    public String home(HttpServletRequest request, Model model) {
        LinkedList<String> visitHistory = getVisitHistory(request);
        model.addAttribute("visitHistory", String.join(", ", visitHistory));
        model.addAttribute("currentPage", "/");
        return "home";
    }

    private LinkedList<String> getVisitHistory(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            Optional<Cookie> visitCookie = Arrays.stream(cookies)
                    .filter(cookie -> COOKIE_NAME.equals(cookie.getName()))
                    .findFirst();

            if (visitCookie.isPresent()) {
                try {
                    String decodedValue = URLDecoder.decode(visitCookie.get().getValue(), StandardCharsets.UTF_8.toString());
                    return new LinkedList<>(Arrays.asList(decodedValue.split(",")));
                } catch (UnsupportedEncodingException e) {
                }
            }
        }
        return new LinkedList<>();
    }
}
```
