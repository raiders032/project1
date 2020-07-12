package com.recoder.project1.web.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {

    private Long id;

    private String email;

    private String nickname;

    private String sex;

    private int age;

    private String grade;

    public UserResponseDto(Long id, String email, String nickname, String sex, int age, String grade) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.sex = sex;
        this.age = age;
        this.grade = grade;
    }
}
