package com.recoder.project1.domain.person;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    @OneToMany(mappedBy = "person")
    List<PersonCategory> categories = new ArrayList<>();

    @OneToMany(mappedBy = "person")
    List<Bookmark> bookmarks = new ArrayList<>();

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String nickname;

    private String sex;

    private int age;

    private String grade;

    @Builder
    public Person(String email, String nickname, String sex, int age, String grade) {
        this.email=email;
        this.nickname=nickname;
        this.sex=sex;
        this.age=age;
        this.grade=grade;
    }
}
