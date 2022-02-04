package com.zzang.shop.domain.buyer;

import com.zzang.shop.domain.common.Address;
import com.zzang.shop.domain.seller.Store;
import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@Entity
@Table(name = "shop_orders")
@Getter
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;
    private int orderPrice; // 주문 총 가격

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "BUYER_ID")
    private Buyer buyer;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "STORE_ID")
    private Store store;

    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    @Embedded
    private Address address;

    //== 연관관계 편의 메서드 ==\\
    public void addDeliveryWithOrder(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    public void addBuyerWithOrder(Buyer buyer) {
        this.buyer = buyer;
        buyer.getOrderList().add(this);
    }

    public void addStoreWithOrder(Store store) {
        this.store = store;
        store.getOrderList().add(this);
    }

}
