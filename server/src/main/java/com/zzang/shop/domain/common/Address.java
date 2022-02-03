package com.zzang.shop.domain.common;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable
public class Address {
    private String city; // 지역
    private String street; // 구/동
    private String home; // 상세주소
}
