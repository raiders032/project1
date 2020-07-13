package com.recoder.project1.service;

import com.recoder.project1.domain.user.User;
import com.recoder.project1.domain.user.UserRepository;
import com.recoder.project1.auth.dto.SessionUser;
import com.recoder.project1.web.user.dto.UserSaveRequestDto;
import com.recoder.project1.web.user.dto.UserResponseDto;
import com.recoder.project1.web.user.dto.UserSaveResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserSaveResponse save(UserSaveRequestDto requestDto) {
        User save = userRepository.save(requestDto.toEntity());
        SessionUser sessionUser = modelMapper.map(save, SessionUser.class);
        return new UserSaveResponse(sessionUser);
    }

    public List<UserResponseDto> findAll() {
        return  userRepository.findAllCustom();
    }

}
