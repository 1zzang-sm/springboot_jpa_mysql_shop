package com.zzang.shop.service.impl;

import com.zzang.shop.domain.seller.Seller;
import com.zzang.shop.domain.seller.Store;
import com.zzang.shop.dto.member.SellerDTO;
import com.zzang.shop.repository.SellerRepository;
import com.zzang.shop.repository.StoreRepository;
import com.zzang.shop.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final StoreRepository storeRepository;

    @Override
    public Long joinSellerAndCreateStore(SellerDTO sellerDTO, String name, String introduce) {
        Seller seller = sellerDTO.joinEntity();
        Store store = Store.createdStore(seller, name, introduce);
        storeRepository.save(store);
        return seller.getId();
    }

}






