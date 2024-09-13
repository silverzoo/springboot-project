package com.elice.project.weeklytest.chapter12.mapper;

import com.elice.project.weeklytest.chapter12.entity.Subject;
import com.elice.project.weeklytest.chapter12.entity.SubjectPatchDto;
import com.elice.project.weeklytest.chapter12.entity.SubjectPostDto;
import com.elice.project.weeklytest.chapter12.entity.SubjectResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMappers {

    Subject subjectPatchDtoToSubject(SubjectPatchDto subjectPatchDto);

    SubjectResponseDto subjectToSubjectResponseDto(Subject subject);

    Subject subjectPostDtoToSubject(SubjectPostDto subjectPostDto);
}
