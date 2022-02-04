package com.zzang.shop.service.impl;

import com.zzang.shop.domain.seller.Seller;
import com.zzang.shop.domain.seller.Store;
import com.zzang.shop.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    // SELLER 등급의 회원이 Store를 생성
    public Long createdStore(Seller seller, String name, String introduce) {
        Store store = Store.createdStore(seller, name, introduce);
        return store.getId();
    }


}
