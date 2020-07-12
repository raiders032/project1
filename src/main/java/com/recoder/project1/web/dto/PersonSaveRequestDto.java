package com.recoder.project1.web.dto;

import com.recoder.project1.domain.person.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonSaveRequestDto {

    @NotBlank(message = "email 형식을 지켜주세요")
    @Email
    private String email;

    @Length(min = 3, max = 20, message = "최소 3 최대 20글자만 가능")
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9_-]{3,20}$",message = "특수문자 ㄴㄴ")
    @NotBlank(message = "nickname을 입력해 주세요")
    private String nickname;

    private String sex;

    private int age;

    public Person toEntity(){
        return Person.builder()
                .email(email)
                .sex(sex)
                .nickname(nickname)
                .age(age)
                .build();
    }

}
