package com.recoder.project1.web;

import com.recoder.project1.service.PersonService;
import com.recoder.project1.web.dto.PersonResponseDto;
import com.recoder.project1.web.dto.PersonSaveRequestDto;
import com.recoder.project1.web.dto.PersonSaveResponse;
import com.recoder.project1.web.validator.PersonSaveRequestDtoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
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
