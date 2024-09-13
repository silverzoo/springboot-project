package com.elice.project.weeklytest.chapter12.service;

import com.elice.project.weeklytest.chapter12.entity.Subject;
import com.elice.project.weeklytest.chapter12.exception.ExceptionCode;
import com.elice.project.weeklytest.chapter12.exception.ServiceLogicException;
import com.elice.project.weeklytest.chapter12.repository.SubjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> findSubjects() {
        return subjectRepository.findAll();
    }

    public Page<Subject> findSubjects(Pageable pageable) {
        return subjectRepository.findAll(pageable);
    }

    public Page<Subject> findAllSubjectsOrderedByPriceAsc(Pageable pageable) {
        return subjectRepository.findAllByOrderByPriceAsc(pageable);
    }

    public Page<Subject> findAllSubjectsOrderedByPriceDesc(Pageable pageable) {
        return subjectRepository.findAllByOrderByPriceDesc(pageable);
    }

    public Subject findSubject(long subjectId) {
        return subjectRepository.findById(subjectId)
                .orElseThrow(() -> new ServiceLogicException(ExceptionCode.SUBJECT_NOT_FOUND));
    }

    @Transactional
    public Subject createSubject(Subject subject) {

        Subject savedSubject = subjectRepository.save(subject);

        return savedSubject;
    }

    @Transactional
    public Subject updateSubject(Subject subject) {

        Subject findSubject = subjectRepository.findById(subject.getSubjectId())
                .orElseThrow(() -> new ServiceLogicException(ExceptionCode.SUBJECT_NOT_FOUND));


        Optional.ofNullable(subject.getName())
                .ifPresent(name -> findSubject.setName(name));
        Optional.ofNullable(subject.getPrice())
                .ifPresent(price -> findSubject.setPrice(price));

        return subjectRepository.save(findSubject);
    }

    public void deleteSubject(long subjectId) {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(
                () -> new ServiceLogicException(ExceptionCode.SUBJECT_NOT_FOUND)
        );

        subjectRepository.delete(subject);
    }

}
