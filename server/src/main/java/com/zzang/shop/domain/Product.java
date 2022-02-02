package com.zzang.shop.domain;

import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@Entity
@Getter
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String productName;

    private int productPrice;
    private int productStockQuantity;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    private Store store;

}
