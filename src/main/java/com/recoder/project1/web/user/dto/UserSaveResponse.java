package com.recoder.project1.web.user.dto;

import com.recoder.project1.auth.dto.SessionUser;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

import java.util.List;

@Getter
@NoArgsConstructor
public class UserSaveResponse {
    @ApiParam(value = "person 객체", required = true)
    private SessionUser sessionUser;
    private List<FieldError> errors;

    public UserSaveResponse(List<FieldError> errors) {
        this.errors = errors;
    }

    public UserSaveResponse(SessionUser sessionUser) {
        this.sessionUser = sessionUser;
    }
}
