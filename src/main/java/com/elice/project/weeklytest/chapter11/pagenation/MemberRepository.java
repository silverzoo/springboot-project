package com.elice.project.weeklytest.chapter11.pagenation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 지시사항을 참고하여 코드를 작성해 보세요.
    List<Member> findMemberByEmailEndingWith(String email);

}