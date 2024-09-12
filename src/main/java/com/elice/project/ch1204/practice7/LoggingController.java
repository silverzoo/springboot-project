package com.elice.project.ch1204.practice7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;

@RestController
public class LoggingController {

    @PostMapping("/setting/logging")
    public ResponseEntity<String> changeLogLevel(
            @RequestParam(name = "package") String packageName,
            @RequestParam(name = "level") String level
    ) {

        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        ch.qos.logback.classic.Logger logger = loggerContext.getLogger(packageName);

        switch(level.toUpperCase()) {
            case "DEBUG":
                logger.setLevel(Level.DEBUG);
                break;
            case "INFO":
                logger.setLevel(Level.INFO);
                break;
            case "WARN":
                logger.setLevel(Level.WARN);
                break;
            case "ERROR":
                logger.setLevel(Level.ERROR);
                break;
            default:
                return ResponseEntity.badRequest().body("Invalid log level");
        }

        return ResponseEntity.ok("Log level for package " + packageName + " set to " + level);
    }
}
