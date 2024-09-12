package com.elice.project.ch1204.practice1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
@RestController
public class LogController {
    // 지시사항에 따라 코드를 작성해 보세요.
    private final Logger log = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/")
    public void log() {
        log.trace("TRACE message");
        log.debug("DEBUG message");
        log.info("INFO message");
        log.warn("WARN message");
        log.error("ERROR message");
    }
}