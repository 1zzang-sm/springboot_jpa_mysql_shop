package com.zzang.shop.domain.seller;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "shop_product")
@Getter
@Setter
@Builder
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(length = 100)
    private String productName;
    private int productPrice;
    private int productStockQuantity;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "STORE_ID")
    private Store store;

    //== 연관관계 편의 메서드 ==\\
    public void addProductWithStore(Store store) {
        this.store = store;
        store.getProductList().add(this);
    }

    //== 생성 메서드 ==\\
    public static Product createdProduct(Store store, Product pd) {
        Product product = Product.builder()
                .productName(pd.getProductName())
                .productPrice(pd.getProductPrice())
                .productStockQuantity(pd.getProductStockQuantity())
                .build();
        product.addProductWithStore(store);
        return product;
    }


}
