package com.elice.project.ch1101.practice2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    public Member save(Member member);
    public Optional<Member> findById(Long id);
    public boolean existsByNickname(String nickname);
}
