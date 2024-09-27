package com.elice.project.weeklytest.chapter13.member.repository;

import com.elice.project.weeklytest.chapter13.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAll();

    Optional<Member> findById(Long memberId);

    Member save(Member member);

    void delete(Member member);
}
