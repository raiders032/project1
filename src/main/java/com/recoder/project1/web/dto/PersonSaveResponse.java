package com.recoder.project1.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class PersonSaveResponse {
    Long id;
    List<FieldError> errors;

    public PersonSaveResponse(List<FieldError> errors) {
        this.errors = errors;
    }

    public PersonSaveResponse(Long id) {
        this.id = id;
    }

}
