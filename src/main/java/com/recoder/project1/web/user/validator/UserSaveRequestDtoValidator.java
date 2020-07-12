package com.recoder.project1.web.user.validator;

import com.recoder.project1.domain.user.UserRepository;
import com.recoder.project1.web.user.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@RequiredArgsConstructor
@Component
public class UserSaveRequestDtoValidator implements Validator {

    private final UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserSaveRequestDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserSaveRequestDto requestDto = (UserSaveRequestDto)target;
        if(userRepository.existsByEmail(requestDto.getEmail())){
            errors.rejectValue("email","wrong.email","중복되는 email입니다");
        }
        if(userRepository.existsByNickname(requestDto.getNickname())){
            errors.rejectValue("nickname","wrong.nickname","중복되는 nickname입니다");
        }
    }
}
