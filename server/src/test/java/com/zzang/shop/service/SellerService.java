package com.zzang.shop.service;

import com.zzang.shop.domain.seller.Seller;
import com.zzang.shop.domain.seller.Store;
import com.zzang.shop.domain.seller.enumeration.Role;
import com.zzang.shop.repository.SellerRepository;
import com.zzang.shop.repository.StoreRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Rollback(value = false)
@Transactional
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private StoreRepository storeRepository;

    @DisplayName("SELLER는 STORE를 가질 수 있다.")
    @Test
    void createdStore() {
//        Seller seller = new Seller();
//        seller.setSellerId("blosw123");
//        seller.setSellerPassword("password");
//        seller.setSellerEmail("captain1152@naver.com");
//        seller.setSellerTel("010-2206-1152");
//        seller.setSellerUsername("이판매자");
//        seller.setRole(Role.NORMAL);
//
//        Store store = new Store();
//        store.setStoreName("그냥store");
//        store.setStoreIntroduce("안녕하세요");
//        store.setSeller(seller);
//
//        storeRepository.save(store);
//
//        System.out.println(store.getSeller().getSellerUsername());
    }


}
