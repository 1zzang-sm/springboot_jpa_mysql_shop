package com.zzang.shop.domain.delivery;

import com.zzang.shop.domain.common.Address;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Delivery {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus; // ORDER(최초 주문시), CANCEL(취소시), COMP(SELLER 등급이 배송완료시)

    @Embedded
    private Address address;

}
