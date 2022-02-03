package com.zzang.shop.domain.seller;

import com.zzang.shop.domain.seller.enumeration.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.EnumType.*;
import static javax.persistence.FetchType.*;

@Entity
@Table(name = "shop_seller")
@Getter
@Setter
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SELLER_ID")
    private Long id;

    @Column(name = "seller_user_id", length = 20)
    private String sellerId;
    @Column(length = 30)
    private String sellerPassword;
    @Column(length = 10)
    private String sellerUsername;
    @Column(length = 13)
    private String sellerTel;
    @Column(length = 50)
    private String sellerEmail;

    @Enumerated(STRING)
    private Role role; // GOOD, NORMAL, BAD

    @OneToOne(mappedBy = "seller", fetch = LAZY)
    private Store store;
}
