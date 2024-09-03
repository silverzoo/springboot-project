package com.elice.project.ch1104.practice2;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member save(Member member);
    Optional<Member> findById(Long id);

    // 지시사항에 따라 메서드를 작성해 주세요.
    boolean existsByNickname(String nickname);
    boolean existsByEmail(String Email);

}
