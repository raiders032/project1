package com.recoder.project1.web.dto;

import com.recoder.project1.domain.person.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonSaveRequestDto {

    private String email;

    private String nickname;

    private String sex;

    private int age;

    private String grade;

    public Person toEntity(){
        return Person.builder()
                .email(email)
                .grade(grade)
                .sex(sex)
                .nickname(nickname)
                .age(age)
                .build();
    }

}
