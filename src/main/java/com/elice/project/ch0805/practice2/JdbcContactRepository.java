package com.elice.project.ch0805.practice2;

import com.elice.project.ch0805.practice1.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcContactRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 연락처를 저장하는 메서드
    public Contact save(Contact contact) {
        // contactId가 없는 경우(새로운 연락처를 저장)
        if (contact.getContactId() == null) {
            // 생성된 키를 저장할 KeyHolder 객체 생성
            KeyHolder keyHolder = new GeneratedKeyHolder();

            // INSERT 쿼리 실행
            jdbcTemplate.update(
                    connection -> {
                        // PreparedStatement를 통해 SQL 쿼리 작성, 생성된 키 반환 설정
                        String sql = "INSERT INTO contact (name, phone_number, email) VALUES (?, ?, ?)";
                        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                        // 연락처 데이터를 PreparedStatement에 설정
                        ps.setString(1, contact.getName());
                        ps.setString(2, contact.getPhoneNumber());
                        ps.setString(3, contact.getEmail());
                        // PreparedStatement 반환
                        return ps;
                    },
                    keyHolder  // 생성된 키 값을 저장할 객체 전달
            );

            // 삽입된 연락처의 ID 값을 keyHolder로부터 추출하여 contact 객체에 설정
            Number key = keyHolder.getKey();
            if (key != null) {
                contact.setContactId(key.longValue());
            } else {
                throw new RuntimeException("Failed to generate contactId for new contact");  // 키 생성 실패 시 예외 발생
            }
        } else {
            // contactId가 존재하는 경우(기존 연락처 업데이트)
            String sql = "UPDATE contact SET name = ?, phone_number = ?, email = ? WHERE contact_id = ?";
            // 업데이트할 데이터를 PreparedStatement에 설정
            jdbcTemplate.update(sql, contact.getName(), contact.getPhoneNumber(), contact.getEmail(), contact.getContactId());
        }

        // 저장 또는 업데이트된 contact 객체 반환
        return contact;
    }

}
