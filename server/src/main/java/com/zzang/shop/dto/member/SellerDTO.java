package com.zzang.shop.dto.member;

import com.zzang.shop.domain.seller.Seller;
import com.zzang.shop.domain.seller.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class SellerDTO {
    private String sellerId;
    private String sellerPassword;
    private String sellerUsername;
    private String sellerTel;
    private String sellerEmail;

    public Seller joinEntity() {
        return Seller.builder().sellerId(sellerId)
                .sellerPassword(sellerPassword)
                .sellerEmail(sellerEmail)
                .sellerTel(sellerTel)
                .sellerUsername(sellerUsername)
                .role(Role.NORMAL)
                .build();
    }
}
