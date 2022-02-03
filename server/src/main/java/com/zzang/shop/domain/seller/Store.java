package com.zzang.shop.domain.seller;

import com.zzang.shop.domain.buyer.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@Entity
@Table(name = "shop_store")
@Getter
@Setter
public class Store {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STORE_ID")
    private Long id;

    @Column(length = 300)
    private String storeName;
    @Column(length = 2000)
    private String storeIntroduce;

    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "SELLER_ID")
    private Seller seller;

    @OneToMany(mappedBy = "store")
    private List<Product> productList = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "store")
    private List<Order> orderList = new ArrayList<>();



}
