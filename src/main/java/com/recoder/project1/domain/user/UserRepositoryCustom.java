package com.recoder.project1.domain.user;

import com.recoder.project1.web.user.dto.UserResponseDto;

import java.util.List;

public interface UserRepositoryCustom {
    List<UserResponseDto> findAllCustom();
}
