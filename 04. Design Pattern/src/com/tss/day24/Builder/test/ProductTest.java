package com.tss.day24.Builder.test;

import com.tss.day24.Builder.model.Product;

public class ProductTest {
    static void main() {
        //Product created with only a single compulsory constraint
        Product product1 = new Product.Builder("Laptop").build();
        System.out.println(product1);


        //Product created with help of Builder where we can assign value in any order which was the drawback in constructor
        Product product2 = new Product.Builder("Phone")
                .setProductDescription("Samsung Phone")
                .setProductPrice(80000)
                .setProductCount(5)
                .build();
        System.out.println(product2);
    }
}
