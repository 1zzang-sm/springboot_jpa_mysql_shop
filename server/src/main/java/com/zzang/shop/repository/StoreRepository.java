package com.zzang.shop.repository;

import com.zzang.shop.domain.seller.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
