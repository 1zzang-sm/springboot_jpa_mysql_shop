package com.zzang.shop.service;

import com.zzang.shop.domain.Store;
import com.zzang.shop.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 상점 등록
 * (SELLER 등급의 회원은 상점을 만들 수 있다.)
 *
 */
@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public void createdStore(String storeName) {

    }

}
