package com.recoder.project1.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>, UserRepositoryCustom {

    boolean existsByEmail(String email);


    boolean existsByNickname(String nickname);
}
