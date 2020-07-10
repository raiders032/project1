package com.recoder.project1.domain.person;

import com.recoder.project1.web.dto.PersonResponseDto;

import java.util.List;

public interface PersonRepositoryCustom {
    List<PersonResponseDto> findAllCustom();
}
