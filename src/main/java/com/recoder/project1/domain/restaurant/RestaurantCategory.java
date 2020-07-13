package com.recoder.project1.domain.restaurant;

import com.recoder.project1.domain.BaseTimeEntity;
import com.recoder.project1.domain.category.Category;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class RestaurantCategory extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
