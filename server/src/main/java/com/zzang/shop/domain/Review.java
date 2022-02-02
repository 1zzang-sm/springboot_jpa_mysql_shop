package com.zzang.shop.domain;

import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@Entity
@Getter
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "review_title", length = 100)
    private String title;

    @Column(name = "review_content", length = 2000)
    private String content;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    private Store store;

}
