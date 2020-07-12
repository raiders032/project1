package com.recoder.project1.web.person;

import com.recoder.project1.service.PersonService;
import com.recoder.project1.web.person.dto.PersonResponseDto;
import com.recoder.project1.web.person.dto.PersonSaveRequestDto;
import com.recoder.project1.web.person.dto.PersonSaveResponse;
import com.recoder.project1.web.person.validator.PersonSaveRequestDtoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonApiController {

    private final PersonService personService;
    private final PersonSaveRequestDtoValidator personSaveRequestDtoValidator;

    @InitBinder("personSaveRequestDto")
    public void PersonSaveRequestDtoInitBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(personSaveRequestDtoValidator);
    }

    @PostMapping("/api/v1/person")
    public PersonSaveResponse save_person(@Valid @RequestBody PersonSaveRequestDto personSaveRequestDto, Errors errors){
        if(errors.hasErrors()){
            return new PersonSaveResponse(errors.getFieldErrors());
        }
        return personService.save(personSaveRequestDto);
    }

    @GetMapping("/api/v1/person")
    public List<PersonResponseDto> person_list(){
        return personService.findAll();
    }
}
