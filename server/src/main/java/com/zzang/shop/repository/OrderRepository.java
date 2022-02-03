package com.zzang.shop.repository;

import com.zzang.shop.domain.buyer.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
