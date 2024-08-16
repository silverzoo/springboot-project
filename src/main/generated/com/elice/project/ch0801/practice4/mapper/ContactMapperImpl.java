package com.elice.project.ch0801.practice4.mapper;

import com.elice.project.ch0801.practice4.entity.Contact;
import com.elice.project.ch0801.practice4.entity.ContactPostDto;
import com.elice.project.ch0801.practice4.entity.ContactResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-16T22:28:32+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ContactMapperImpl implements ContactMapper {

    @Override
    public Contact toContact(ContactPostDto contactPostDto) {
        if ( contactPostDto == null ) {
            return null;
        }

        Contact contact = new Contact();

        contact.setName( contactPostDto.getName() );
        contact.setPhoneNumber( contactPostDto.getPhoneNumber() );
        contact.setEmail( contactPostDto.getEmail() );

        return contact;
    }

    @Override
    public ContactResponseDto toResponseDto(Contact contact) {
        if ( contact == null ) {
            return null;
        }

        ContactResponseDto contactResponseDto = new ContactResponseDto();

        contactResponseDto.setContactId( contact.getContactId() );
        contactResponseDto.setName( contact.getName() );
        contactResponseDto.setPhoneNumber( contact.getPhoneNumber() );
        contactResponseDto.setEmail( contact.getEmail() );

        return contactResponseDto;
    }
}
