package com.elice.project.ch0802.practice3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class EventRegistrationViewController {
    // private final UserInfoValidator userInfoValidator;

    // @InitBinder
    // public void init(WebDataBinder dataBinder) {
    //     dataBinder.addValidators(userInfoValidator);
    // }

    @GetMapping("/v3/event")
    public String getUserInfo(Model model) {
        model.addAttribute("user", new UserInfoForm());
        return "userInfoForm";
    }

    @PostMapping("/v3/event")
    public String getUserInfo(@Validated @ModelAttribute("user") UserInfoForm userInfoForm, BindingResult bindingResult) {
        log.info("user.isMembership={}", userInfoForm.isMembership());

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "userInfoForm";
        }

        return "confirmForm";
    }
}