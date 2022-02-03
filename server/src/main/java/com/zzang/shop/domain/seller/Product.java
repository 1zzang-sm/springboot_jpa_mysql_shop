package com.zzang.shop.domain.seller;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@Entity
@Table(name = "shop_product")
@Getter
@Setter
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(length = 100)
    private String productName;
    private int productPrice;
    private int productStockQuantity;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "STORE_ID")
    private Store store;


}
