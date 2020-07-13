package com.recoder.project1.domain.user;

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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @OneToMany(mappedBy = "user")
    List<UserCategory> categories = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Bookmark> bookmarks = new ArrayList<>();

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private String sex;

    private int age;

    private String grade ="우유 1단";

    private String picture;

    @Builder
    public User(String email, String nickname, String sex, int age, String grade, String picture, Role role) {
        this.email=email;
        this.nickname=nickname;
        this.sex=sex;
        this.age=age;
        this.grade=grade;
        this.picture=picture;
        this.role=role;
    }
    public User update(String name, String picture){
        this.nickname=name;
        this.picture=picture;
        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}
