package com.elice.project.ch1204.practice2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookReservationController {

    private Logger log = LoggerFactory.getLogger(BookReservationController.class);

    @GetMapping("/book")
    public String reserveBook(@RequestParam String name, @RequestParam String title) {

        log.trace("TRACE message");
        log.debug("DEBUG message");
        log.info("INFO message");
        log.warn("WARN message");
        log.error("ERROR message");

        return "감사합니다 " + name + "님, '" + title + "' 도서 예약이 완료되었습니다!";
    }
}
