package com.recoder.project1.web;

import com.recoder.project1.domain.person.Person;
import com.recoder.project1.service.PersonService;
import com.recoder.project1.web.dto.PersonResponseDto;
import com.recoder.project1.web.dto.PersonSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonApiController {

    private final PersonService personService;

    @PostMapping("/api/v1/person")
    public Long person(@RequestBody PersonSaveRequestDto requestDto){
        return personService.save(requestDto);
    }
/*
    @GetMapping("/api/v1/person")
    public List<Person> person_list(){
        return personService.findAll();
    }*/
}
