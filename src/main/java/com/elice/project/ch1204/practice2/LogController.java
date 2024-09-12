package com.elice.project.ch1204.practice2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    private Logger log = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/")
    public void log() {
        log.trace("TRACE message");
        log.debug("DEBUG message");
        log.info("INFO message");
        log.warn("WARN message");
        log.error("ERROR message");
    }
}