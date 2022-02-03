package com.zzang.shop.domain.buyer;

import com.zzang.shop.domain.buyer.enumeration.DeliveryStatus;
import com.zzang.shop.domain.common.Address;
import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.EnumType.*;
import static javax.persistence.FetchType.*;

@Entity
@Table(name = "shop_delivery")
@Getter
public class Delivery {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DELIVERY_ID")
    private Long id;

    @Enumerated(STRING)
    private DeliveryStatus deliveryStatus;

    @Embedded
    private Address address;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

}
