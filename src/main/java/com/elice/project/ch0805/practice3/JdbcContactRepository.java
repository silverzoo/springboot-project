package com.elice.project.ch0805.practice3;

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

    private RowMapper<Contact> contactRowMapper() {
        return (rs, rowNum) -> {
            Contact contact = new Contact();
            contact.setContactId(rs.getLong("contact_id"));
            contact.setName(rs.getString("name"));
            contact.setPhoneNumber(rs.getString("phone_number"));
            contact.setEmail(rs.getString("email"));
            return contact;
        };
    }

    public Optional<Contact> findById(long id) {
        try {
            Contact contact = jdbcTemplate.queryForObject(
                    "SELECT * FROM contact WHERE contact_id = ?",
                    contactRowMapper(),
                    id
            );
            return Optional.ofNullable(contact);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    // 연락처를 삭제하는 메서드. contact 객체에서 ID를 받아 삭제 쿼리 실행
    public void delete(Contact contact) {
        jdbcTemplate.update(
                "DELETE FROM contact WHERE contact_id = ?", // DELETE SQL 쿼리
                contact.getContactId() // 삭제할 대상의 contact_id
        );
    }
}
