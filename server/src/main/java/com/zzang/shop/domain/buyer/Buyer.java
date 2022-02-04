package com.zzang.shop.domain.buyer;

import com.zzang.shop.domain.buyer.enumeration.Gender;
import com.zzang.shop.domain.buyer.enumeration.Role;
import com.zzang.shop.domain.common.Address;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.EnumType.*;

@Entity
@Table(name = "shop_buyers")
@Getter
@Setter
public class Buyer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BUYER_ID")
    private Long id;

    @Column(name = "buyer_user_id", length = 20)
    private String buyerId;
    @Column(length = 30)
    private String buyerPassword;
    @Column(length = 10)
    private String buyerUsername;
    @Column(length = 11)
    private String buyerTel;
    @Column(length = 50)
    private String buyerEmail;

    @Enumerated(STRING)
    private Gender gender; // MALE, FEMALE

    @Enumerated(STRING)
    private Role role; // VIP, GOLD, SILVER

    @OneToMany(mappedBy = "buyer")
    private List<Order> orderList = new ArrayList<>();

    @Embedded
    private Address address;





}
