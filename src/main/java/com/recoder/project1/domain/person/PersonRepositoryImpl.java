package com.recoder.project1.domain.person;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.recoder.project1.web.person.dto.PersonResponseDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.recoder.project1.domain.person.QPerson.*;

@RequiredArgsConstructor
public class PersonRepositoryImpl implements PersonRepositoryCustom {

    private final  JPAQueryFactory queryFactory;

    @Override
    public List<PersonResponseDto> findAllCustom() {
        return queryFactory.select(Projections.fields(PersonResponseDto.class,
                    person.sex,
                    person.id,
                    person.grade,
                    person.email,
                    person.nickname,
                    person.age
                ))
                .from(person)
                .fetch();
    }
}
