package com.elice.project.ch0801.practice4.mapper;

// 지시사항에 맞게 코드를 수정해 주세요.

import com.elice.project.ch0801.practice4.entity.Contact;
import com.elice.project.ch0801.practice4.entity.ContactPostDto;
import com.elice.project.ch0801.practice4.entity.ContactResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    // 지시사항에 맞게 코드를 수정해 주세요.
    Contact toContact(ContactPostDto contactPostDto); //엔티티 반환
    ContactResponseDto toResponseDto(Contact contact); //responseDTO 반환

}
