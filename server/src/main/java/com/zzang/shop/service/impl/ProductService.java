package com.zzang.shop.service.impl;

import com.zzang.shop.domain.seller.Product;
import com.zzang.shop.domain.seller.Store;
import com.zzang.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Long createdProduct(Store store, Product pd) {
        Product product = Product.createdProduct(store, pd);
        return product.getId();
    }

}
