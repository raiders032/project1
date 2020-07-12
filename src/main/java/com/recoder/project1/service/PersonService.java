package com.recoder.project1.service;

import com.recoder.project1.domain.person.PersonRepository;
import com.recoder.project1.web.person.dto.PersonSaveRequestDto;
import com.recoder.project1.web.person.dto.PersonResponseDto;
import com.recoder.project1.web.person.dto.PersonSaveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public PersonSaveResponse save(PersonSaveRequestDto requestDto) {
        return new PersonSaveResponse(personRepository.save(requestDto.toEntity()));
    }

    public List<PersonResponseDto> findAll() {
        return  personRepository.findAllCustom();
    }

}
