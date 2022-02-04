package com.zzang.shop.domain.seller;

import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@Entity
@Table(name = "shop_review")
@Getter
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID")
    private Long id;

    @Column(length = 100)
    private String reviewTitle;
    @Column(length = 2000)
    private String reviewContent;
    private int reviewStar;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "STORE_ID")
    private Store store;

    //== 연관관계 편의 메서드 ==\\
    public void addReviewWithStore(Store store) {
        this.store = store;
        store.getReviewList().add(this);
    }
}
