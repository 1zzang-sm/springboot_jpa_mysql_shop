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

    @DisplayName("seller는 store를 만들 수 있다.")
    @Test
    void addProduct() {
        Seller seller = Seller.builder()
                .sellerId("blosw123")
                .sellerEmail("captain1152@naver.com")
                .sellerPassword("abc123")
                .sellerTel("01022061152")
                .sellerUsername("이성민")
                .role(Role.NORMAL)
                .build();

        Store store = Store.createdStore(seller, "jpa shop", "introduce..");
        storeRepository.save(store);
//        if(!(seller.getStore() == null)){
//            seller.setRole(Role.NORMAL);
//        }
        System.out.println("store = " + store.getSeller().getSellerId());
    }


}
