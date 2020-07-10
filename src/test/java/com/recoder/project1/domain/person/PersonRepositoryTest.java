package com.recoder.project1.domain.person;


import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static com.recoder.project1.domain.person.QPerson.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class PersonRepositoryTest {

    @Autowired
    private EntityManager em;

    @Autowired
    PersonRepository personRepository;

    private JPAQueryFactory queryFactory;

    @BeforeEach
    public void before(){
        queryFactory = new JPAQueryFactory(em);
    }

    @AfterEach
    public void cleanup(){
        //personRepository.deleteAll();
    }

    @Test
    public void person_save(){
        //given
        int age = 10;
        String email = "abc@abc.com";
        String nickname = "김상덕";
        String grade = "1단";
        String sex = "남자";

        personRepository.save(Person.builder()
                .age(age)
                .email(email)
                .nickname(nickname)
                .sex(sex)
                .grade(grade)
                .build());
        //when
        List<Person> personList = queryFactory
                .select(person)
                .from(person)
                .fetch();

        //then
        Person person = personList.get(0);
        assertThat(person.getNickname()).isEqualTo(nickname);
        assertThat(person.getAge()).isEqualTo(age);
        assertThat(person.getEmail()).isEqualTo(email);
        assertThat(person.getGrade()).isEqualTo(grade);
        assertThat(person.getSex()).isEqualTo(sex);

    }


}