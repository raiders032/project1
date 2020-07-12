package com.recoder.project1.service;

import com.recoder.project1.domain.user.UserRepository;
import com.recoder.project1.web.user.dto.UserSaveRequestDto;
import com.recoder.project1.web.user.dto.UserResponseDto;
import com.recoder.project1.web.user.dto.UserSaveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserSaveResponse save(UserSaveRequestDto requestDto) {
        return new UserSaveResponse(userRepository.save(requestDto.toEntity()));
    }

    public List<UserResponseDto> findAll() {
        return  userRepository.findAllCustom();
    }

}
