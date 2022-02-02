package com.zzang.shop.domain;

import com.zzang.shop.domain.member.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 300)
    private String storeName;
    @Column(length = 2000)
    private String storeIntroduce;

    @OneToOne(fetch = LAZY, cascade = ALL)
    private Member member;

    @OneToMany(mappedBy = "store")
    private List<Order> orderList = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<Product> productList = new ArrayList<>();

    public Store(String storeName, String storeIntroduce) {
        this.storeName = storeName;
        this.storeIntroduce = storeIntroduce;
    }

    public void changeMember(Member member) {
        this.member = member;
    }

}
