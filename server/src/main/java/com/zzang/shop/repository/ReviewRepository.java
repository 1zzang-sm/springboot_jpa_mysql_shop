package com.zzang.shop.repository;

import com.zzang.shop.domain.seller.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
