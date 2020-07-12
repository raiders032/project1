package com.recoder.project1.web.person.dto;

import com.recoder.project1.domain.person.Bookmark;
import com.recoder.project1.domain.person.PersonCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PersonResponseDto {

    private Long id;

    private String email;

    private String nickname;

    private String sex;

    private int age;

    private String grade;

    public PersonResponseDto(Long id, String email, String nickname, String sex, int age, String grade) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.sex = sex;
        this.age = age;
        this.grade = grade;
    }
}
