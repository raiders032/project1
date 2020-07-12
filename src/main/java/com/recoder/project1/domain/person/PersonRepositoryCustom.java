package com.recoder.project1.domain.person;

import com.recoder.project1.web.person.dto.PersonResponseDto;

import java.util.List;

public interface PersonRepositoryCustom {
    List<PersonResponseDto> findAllCustom();
}
