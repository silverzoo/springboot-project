//package com.elice.project.ch0801.practice3;
//
//import com.elice.project.ch0801.practice3.entity.Contact;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import com.elice.project.ch0801.practice3.repository.ContactRepository;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//
//@Slf4j
//@RequiredArgsConstructor
//public class DataInit {
//
//    private final ContactRepository contactRepository;
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void init() {
//        log.info("init stub data");
//        contactRepository.save(new Contact("엘리스", "010-1234-5678", "elicer@elicer.com"));
//        contactRepository.save(new Contact("나토끼", "010-1453-5783", "rabit@elicer.com"));
//    }
//}
