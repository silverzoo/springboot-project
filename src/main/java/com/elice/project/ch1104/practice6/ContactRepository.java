package com.elice.project.ch1104.practice6;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    // 지시사항에 따라 코드를 작성해 보세요.
    // SQL: 데이터베이스의 실제 테이블을 대상으로 직접 쿼리를 작성
    @Query(value= "SELECT * FROM contact WHERE name LIKE ?1%", nativeQuery = true)
    List<Contact> findByNameStartingWith(String name);

    @Query(value= "SELECT * FROM contact WHERE email LIKE ?1%", nativeQuery = true)
    List<Contact> findByEmailEndingWith(String name);

}

