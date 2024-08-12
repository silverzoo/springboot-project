//package com.elice.project.ch0801.practice3.repository;
//
//import com.elice.project.ch0801.practice3.entity.Contact;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Repository;
//
//import java.sql.PreparedStatement;
//import java.sql.Statement;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class JdbcContactRepository {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public JdbcContactRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    private RowMapper<Contact> contactRowMapper() {
//        return (rs, rowNum) -> {
//            Contact contact = new Contact();
//            contact.setContactId(rs.getLong("contact_id"));
//            contact.setName(rs.getString("name"));
//            contact.setPhoneNumber(rs.getString("phone_number"));
//            contact.setEmail(rs.getString("email"));
//            return contact;
//        };
//    }
//
//    public List<Contact> findAll() {
//        return jdbcTemplate.query("SELECT * FROM contact", contactRowMapper());
//    }
//
//    public Optional<Contact> findById(long id) {
//        try {
//            Contact contact = jdbcTemplate.queryForObject(
//                    "SELECT * FROM contact WHERE contact_id = ?",
//                    new Object[]{id},
//                    contactRowMapper()
//            );
//            return Optional.ofNullable(contact);
//        } catch (EmptyResultDataAccessException e) {
//            return Optional.empty();
//        }
//    }
//
//    public Contact save(Contact contact) {
//        if (contact.getContactId() == null) {
//            // Insert new contact and retrieve generated contactId
//            KeyHolder keyHolder = new GeneratedKeyHolder();
//            jdbcTemplate.update(
//                    connection -> {
//                        PreparedStatement ps = connection.prepareStatement(
//                                "INSERT INTO contact (name, phone_number, email) VALUES (?, ?, ?)",
//                                Statement.RETURN_GENERATED_KEYS
//                        );
//                        ps.setString(1, contact.getName());
//                        ps.setString(2, contact.getPhoneNumber());
//                        ps.setString(3, contact.getEmail());
//                        return ps;
//                    },
//                    keyHolder
//            );
//            // Set the generated contactId to the contact object
//            Number key = keyHolder.getKey();
//            if (key != null) {
//                contact.setContactId(key.longValue());
//            } else {
//                // Handle the scenario where key generation failed
//                throw new RuntimeException("Failed to generate contactId for new contact");
//            }
//        } else {
//            // Update existing contact
//            jdbcTemplate.update(
//                    "UPDATE contact SET name = ?, phone_number = ?, email = ? WHERE contact_id = ?",
//                    contact.getName(), contact.getPhoneNumber(), contact.getEmail(), contact.getContactId()
//            );
//        }
//        return contact;
//    }
//
//    public void delete(Contact contact) {
//        jdbcTemplate.update(
//                "DELETE FROM contact WHERE contact_id = ?",
//                contact.getContactId()
//        );
//    }
//}
