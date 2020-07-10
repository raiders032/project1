package com.recoder.project1.service;

import com.recoder.project1.domain.person.Person;
import com.recoder.project1.domain.person.PersonRepository;
import com.recoder.project1.web.dto.PersonSaveRequestDto;
import com.recoder.project1.web.dto.PersonResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;


    public Long save(PersonSaveRequestDto requestDto) {
        return personRepository.save(requestDto.toEntity()).getId();
    }

  /*  public List<Person> findAll() {
       return  personRepository.findAllPersonCustom();
    }*/
}
