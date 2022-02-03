package com.zzang.shop.repository;

import com.zzang.shop.domain.seller.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
