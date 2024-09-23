```java
package com.elice.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FrontController {

    //쿠키초기화 로직        
    @GetMapping("/")
    public String homePage(HttpServletRequest request, Model model) {
        String theme = "light"; // 기본 테마
        Cookie[] cookies = request.getCookies();

        // 지시사항을 참고하여 코드를 작성해 보세요.
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("preferred-theme".equals(cookie.getName())) {
                    theme = cookie.getValue();
                    break;
                }
            }
        }
        model.addAttribute("theme", theme);

        return "home";
    }

    //쿠키수정 로직
    @PostMapping("/set-theme")
    public String setTheme(@RequestParam String theme, HttpServletResponse response) {
        Cookie cookie = new Cookie("preferred-theme", theme);
        cookie.setMaxAge(30 * 24 * 60 * 60); // 30일
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin-page";
    }

    @GetMapping("/my-page")
    public String myPage() {
        return "my-page";
    }

    @GetMapping("/login-form")
    public String loginForm() {
        return "login-form";
    }

    @GetMapping("/member-register")
    public String memberRegister() {
        return "member-register";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

    @GetMapping("/theme-settings")
    public String themeSettings() {
        return "theme-settings";
    }
}
```
