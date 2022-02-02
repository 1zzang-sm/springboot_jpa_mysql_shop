package com.zzang.shop.domain.common;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String home;

    public Address() {
    }

    public Address(String city, String street, String home) {
        this.city = city;
        this.street = street;
        this.home = home;
    }

}
