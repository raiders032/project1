package com.recoder.project1.web;


import com.recoder.project1.domain.person.Person;
import com.recoder.project1.domain.person.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class HelloController {

    private final PersonRepository personRepository;

    @GetMapping("/hello")
    @ResponseBody
    public List<Person> hello() {
        List<Person> all = personRepository.findAll();
        return all;
    }


}