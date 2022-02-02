package com.zzang.shop.domain;

import com.zzang.shop.domain.member.Member;
import lombok.Getter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@Entity
@Getter
public class Store {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 300)
    private String storeName;
    @Column(length = 2000)
    private String storeIntroduce;

    @OneToOne(fetch = LAZY, cascade = ALL)
    private Member member;

    @OneToMany
    private List<Order> orderList = new ArrayList<>();

    @OneToMany
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany
    private List<Product> productList = new ArrayList<>();

}
