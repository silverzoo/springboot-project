package com.elice.project.weeklytest.chapter12.controller;

import com.elice.project.weeklytest.chapter12.entity.Subject;
import com.elice.project.weeklytest.chapter12.entity.SubjectPatchDto;
import com.elice.project.weeklytest.chapter12.entity.SubjectPostDto;
import com.elice.project.weeklytest.chapter12.mapper.SubjectMappers;
import com.elice.project.weeklytest.chapter12.service.SubjectService;
import jakarta.validation.constraints.Positive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;
    private final SubjectMappers mapper;
    private static final Logger log = LoggerFactory.getLogger(SubjectController.class);

    public SubjectController(SubjectService subjectService, SubjectMappers mapper) {
        this.subjectService = subjectService;
        this.mapper = mapper;
    }

    @GetMapping("/{subjectId}")
    public ResponseEntity getSubject(@PathVariable("subjectId") long subjectId) {
        //log.info("과목 조회 요청: 과목 ID {}", subjectId);
        Subject findSubject = subjectService.findSubject(subjectId);

        if (findSubject == null) {
            log.warn("과목 조회 실패: 과목 ID {}, 상태: 404", subjectId);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(findSubject, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getSubjects() {
        List<Subject> subjects = subjectService.findSubjects();
        if (subjects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity postSubject(@RequestBody SubjectPostDto subjectPostDto) {
        Subject subject = subjectPostDto.toEntity();

        Subject newSubject = subjectService.createSubject(subject);

        if (newSubject == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(newSubject, HttpStatus.CREATED);
    }

    @PatchMapping("/{subjectId}")
    public ResponseEntity patchSubject(@PathVariable long subjectId, @RequestBody SubjectPatchDto subjectPatchDto) {
        subjectPatchDto.setSubjectId(subjectId);
        Subject subject = subjectService.updateSubject(mapper.subjectPatchDtoToSubject(subjectPatchDto));
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity deleteSubject(@PathVariable("subjectId") @Positive long subjectId) {
        subjectService.deleteSubject(subjectId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
