package com.zzang.shop.service;

import com.zzang.shop.domain.seller.Product;
import com.zzang.shop.domain.seller.Seller;
import com.zzang.shop.domain.seller.Store;
import com.zzang.shop.domain.seller.enumeration.Role;
import com.zzang.shop.repository.ProductRepository;
import com.zzang.shop.repository.StoreRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private EntityManager em;

    @DisplayName("스토어는 상품을 가질 수 있다.")
    @Test
    void addProduct() {
        Seller seller = new Seller();
        seller.setSellerId("blosw123");
        seller.setSellerPassword("password");
        seller.setSellerEmail("captain1152@naver.com");
        seller.setSellerTel("010-2206-1152");
        seller.setSellerUsername("이판매자");
        seller.setRole(Role.NORMAL);

        Store store = new Store();
        store.setStoreName("그냥store");
        store.setStoreIntroduce("안녕하세요");
        store.setSeller(seller);

        storeRepository.save(store);

        Product product = new Product();
        product.setProductName("텀블러");
        product.setProductPrice(20000);
        product.setProductStockQuantity(10);
        product.setStore(store);
        productRepository.save(product);

        System.out.println("product.storename = " + product.getStore().getStoreName());
//        Product product1 = store.getProductList().get(1);
//        System.out.println("productList = " + product1.getProductName());
    }


}
