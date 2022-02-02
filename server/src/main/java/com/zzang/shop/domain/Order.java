package com.zzang.shop.domain;

import com.zzang.shop.domain.delivery.Delivery;
import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@Entity
@Table(name = "orders")
@Getter
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int orderPrice;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    private Store store;

    @OneToOne(fetch = LAZY, cascade = ALL)
    private Delivery delivery;



}
