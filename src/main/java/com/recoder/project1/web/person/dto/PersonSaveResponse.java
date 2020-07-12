package com.recoder.project1.web.person.dto;

import com.recoder.project1.domain.person.Person;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class PersonSaveResponse {
    @ApiParam(value = "person 객체", required = true)
    private Person person;
    private List<FieldError> errors;

    public PersonSaveResponse(List<FieldError> errors) {
        this.errors = errors;
    }

    public PersonSaveResponse(Person person) {
        this.person = person;
    }
}
