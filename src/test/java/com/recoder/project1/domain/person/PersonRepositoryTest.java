package com.recoder.project1.domain.person;


import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
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

    @Test
    public void find_all_person_custom(){
        //given
        Person person1 = personRepository.save(Person.builder()
                .email("123@naver.com")
                .build());
        Person person2 = personRepository.save(Person.builder()
                .email("456@naver.com")
                .build());

        //when
        List<Person> people = personRepository.findAllPersonCustom();

        //then
        Person person= people.get(0);
        Assertions.assertThat(person.getEmail()).isEqualTo("123@naver.com");
        Assertions.assertThat(people.size()).isEqualTo(2);
    }
}