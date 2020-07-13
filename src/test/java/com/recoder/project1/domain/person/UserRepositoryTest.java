package com.recoder.project1.domain.person;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.recoder.project1.domain.user.Role;
import com.recoder.project1.domain.user.User;
import com.recoder.project1.domain.user.UserRepository;
import com.recoder.project1.web.user.dto.UserResponseDto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.recoder.project1.domain.user.QUser.*;
import static org.assertj.core.api.Assertions.*;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private JPAQueryFactory queryFactory;

    @Test
    public void person_save(){
        //given
        int age = 10;
        String email = "abc@abc.com";
        String nickname = "김상덕";
        String grade = "1단";
        String sex = "남자";

        userRepository.save(User.builder()
                .age(age)
                .email(email)
                .role(Role.GUEST)
                .nickname(nickname)
                .sex(sex)
                .grade(grade)
                .build());
        //when
        List<User> userList = queryFactory
                .select(user)
                .from(user)
                .fetch();

        //then
        User user = userList.get(0);
        assertThat(user.getNickname()).isEqualTo(nickname);
        assertThat(user.getAge()).isEqualTo(age);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getGrade()).isEqualTo(grade);
        assertThat(user.getSex()).isEqualTo(sex);

    }

    @Test
    public void find_all_person_custom(){
        //given
        User user1 = userRepository.save(User.builder()
                .role(Role.GUEST)
                .email("123@naver.com")
                .build());
        User user2 = userRepository.save(User.builder()
                .role(Role.GUEST)
                .email("456@naver.com")
                .build());

        //when
        List<UserResponseDto> persons = userRepository.findAllCustom();

        //then
        UserResponseDto personDto= persons.get(0);
        assertThat(personDto.getEmail()).isEqualTo("123@naver.com");
        assertThat(persons.size()).isEqualTo(2);
    }

}