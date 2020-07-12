package com.recoder.project1.web.validator;

import com.recoder.project1.domain.person.PersonRepository;
import com.recoder.project1.web.dto.PersonSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@RequiredArgsConstructor
@Component
public class PersonSaveRequestDtoValidator implements Validator {

    private final PersonRepository personRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return PersonSaveRequestDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PersonSaveRequestDto requestDto = (PersonSaveRequestDto)target;
        if(personRepository.existsByEmail(requestDto.getEmail())){
            errors.rejectValue("email","wrong.email","중복되는 email입니다");
        }
    }
}
