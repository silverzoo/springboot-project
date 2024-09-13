package com.elice.project.weeklytest.chapter12.repository;

import com.elice.project.weeklytest.chapter12.entity.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    Page<Subject> findAllByOrderByPriceAsc(Pageable pageable);

    Page<Subject> findAllByOrderByPriceDesc(Pageable pageable);
}