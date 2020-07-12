package com.recoder.project1.web;

import com.recoder.project1.service.UserService;
import com.recoder.project1.web.user.dto.UserResponseDto;
import com.recoder.project1.web.user.dto.UserSaveRequestDto;
import com.recoder.project1.web.user.dto.UserSaveResponse;
import com.recoder.project1.web.user.validator.UserSaveRequestDtoValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "UserController V1")
@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    private final UserSaveRequestDtoValidator userSaveRequestDtoValidator;

    @InitBinder("userSaveRequestDto")
    public void PersonSaveRequestDtoInitBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(userSaveRequestDtoValidator);
    }

    @ApiOperation(value = "save_user" , notes = "사용자를 저장하고 사용자의 정보를 반환한다.")
    @PostMapping("/api/v1/user")
    public UserSaveResponse save_user(@Valid @RequestBody UserSaveRequestDto userSaveRequestDto, Errors errors){
        if(errors.hasErrors()){
            return new UserSaveResponse(errors.getFieldErrors());
        }
        return userService.save(userSaveRequestDto);
    }

    @ApiOperation(value = "user" , notes = "사용자 목록 반환")
    @GetMapping("/api/v1/user")
    public List<UserResponseDto> user_list(){
        return userService.findAll();
    }
}
