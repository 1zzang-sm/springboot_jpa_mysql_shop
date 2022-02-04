package com.zzang.shop.domain.seller;

import com.zzang.shop.domain.buyer.Order;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "shop_store")
@Getter
@Setter
@Builder
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

    public Store(Seller seller, String name, String introduce) {

    }

    //== 연관관계 편의 메서드 ==\\
    public void addSellerWithStore(Seller seller) {
        this.seller = seller;
        seller.setStore(this);
    }

    //== 생성메서드 ==\\
    public static Store createdStore(Seller seller, String name, String introduce) {
        Store store = Store.builder().storeName(name).storeIntroduce(introduce).build();
        store.addSellerWithStore(seller);
        return store;
    }

}
