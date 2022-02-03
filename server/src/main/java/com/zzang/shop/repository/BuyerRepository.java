package com.zzang.shop.repository;

import com.zzang.shop.domain.buyer.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
