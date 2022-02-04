package com.zzang.shop.service;

import com.zzang.shop.dto.member.SellerDTO;

public interface SellerService {

    public Long joinSellerAndCreateStore(SellerDTO sellerDTO, String name, String introduce);
}
