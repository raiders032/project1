package com.recoder.project1.web.user.dto;

import com.recoder.project1.domain.user.User;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

import java.util.List;

@Getter
@NoArgsConstructor
public class UserSaveResponse {
    @ApiParam(value = "person 객체", required = true)
    private User user;
    private List<FieldError> errors;

    public UserSaveResponse(List<FieldError> errors) {
        this.errors = errors;
    }

    public UserSaveResponse(User user) {
        this.user = user;
    }
}
