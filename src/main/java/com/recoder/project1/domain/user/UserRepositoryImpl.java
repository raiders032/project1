package com.recoder.project1.domain.user;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.recoder.project1.web.user.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.recoder.project1.domain.user.QUser.*;


@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final  JPAQueryFactory queryFactory;

    @Override
    public List<UserResponseDto> findAllCustom() {
        return queryFactory.select(Projections.fields(UserResponseDto.class,
                    user.sex,
                    user.id,
                    user.grade,
                    user.email,
                    user.nickname,
                    user.age
                ))
                .from(user)
                .fetch();
    }
}
