package com.zzang.shop.repository;

import com.zzang.shop.domain.seller.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
