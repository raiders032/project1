package com.recoder.project1.domain.restaurant;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Menu> menuList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<RestaurantPhoto> photos = new ArrayList<>();

    @Column(nullable = false)
    private String name;

    private double google_rating;

    private double naver_rating;

    private int naver_review_count ;

    private int google_review_count ;

    private String opening_hours;

    private String business_status;

    private int price_level;

    private String address;

    private float longitude;

    private float latitude;

    private String phone;
}
