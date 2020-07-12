package com.recoder.project1.domain.person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long>, PersonRepositoryCustom{

    boolean existsByEmail(String email);
}
