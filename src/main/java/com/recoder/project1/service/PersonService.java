package com.recoder.project1.service;

import com.recoder.project1.domain.person.PersonRepository;
import com.recoder.project1.web.dto.PersonSaveRequestDto;
import com.recoder.project1.web.dto.PersonResponseDto;
import com.recoder.project1.web.dto.PersonSaveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public PersonSaveResponse save(PersonSaveRequestDto requestDto) {
        Long id = personRepository.save(requestDto.toEntity()).getId();
        return new PersonSaveResponse(id);
    }

    public List<PersonResponseDto> findAll() {
        return  personRepository.findAllCustom();
    }

}
