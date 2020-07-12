package com.recoder.project1.web.person.dto;

import com.recoder.project1.domain.person.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class PersonSaveResponse {
    private Person person;
    private List<FieldError> errors;

    public PersonSaveResponse(List<FieldError> errors) {
        this.errors = errors;
    }

    public PersonSaveResponse(Person person) {
        this.person = person;
    }
}
