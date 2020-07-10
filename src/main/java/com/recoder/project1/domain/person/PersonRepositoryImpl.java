package com.recoder.project1.domain.person;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

import static com.recoder.project1.domain.person.QPerson.*;

@RequiredArgsConstructor
public class PersonRepositoryImpl implements PersonRepositoryCustom {

    private final  JPAQueryFactory queryFactory;

    @Override
    public List<Person> findAllPersonCustom() {
        List<Person> people = queryFactory.select(person)
                .from(person)
                .fetch();
        return people;
    }
}
