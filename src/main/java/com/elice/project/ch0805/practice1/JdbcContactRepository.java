package com.elice.project.ch0805.practice1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcContactRepository {

    private final JdbcTemplate jdbcTemplate;

    // JdbcTemplate을 의존성 주입 받음
    @Autowired
    public JdbcContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper를 구현하여 ResultSet을 Contact 객체로 매핑
    private RowMapper<Contact> contactRowMapper() {
        return (rs, rowNum) -> {
            Contact contact = new Contact();  // 새로운 Contact 객체 생성
            contact.setContactId(rs.getLong("contact_id"));  // ResultSet에서 contact_id 열의 값을 Contact 객체에 설정
            contact.setName(rs.getString("name"));  // ResultSet에서 name 열의 값을 Contact 객체에 설정
            contact.setPhoneNumber(rs.getString("phone_number"));  // ResultSet에서 phone_number 열의 값을 Contact 객체에 설정
            contact.setEmail(rs.getString("email"));  // ResultSet에서 email 열의 값을 Contact 객체에 설정
            return contact;  // 매핑된 Contact 객체 반환
        };
    }

    // 모든 연락처를 조회하는 메서드 구현
    public List<Contact> findAll() {
        // SELECT 쿼리를 사용하여 모든 연락처를 조회하고, RowMapper를 통해 Contact 객체로 변환
        String sql = "SELECT * FROM contact";
        return jdbcTemplate.query(sql, contactRowMapper());
    }

    // ID로 연락처를 조회하는 메서드 구현
    public Optional<Contact> findById(long id) {
        try {
            // 주어진 ID로 연락처를 조회하고, RowMapper를 사용해 Contact 객체로 변환
            String sql = "SELECT * FROM contact WHERE contact_id = ?";
            Contact contact = jdbcTemplate.queryForObject(sql, contactRowMapper(), id);
            // 조회된 연락처를 Optional로 반환
            return Optional.ofNullable(contact);
        } catch (EmptyResultDataAccessException e) {
            // 결과가 없을 경우 Optional.empty()를 반환하여 빈 값을 처리
            return Optional.empty();
        }
    }
}
