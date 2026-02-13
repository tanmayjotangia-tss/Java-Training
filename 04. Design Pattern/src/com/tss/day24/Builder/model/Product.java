package com.tss.day24.Builder.model;

public class Product {
    private String productName;
    private String productDescription;
    private int productPrice;
    private int productCount;

    @Override
    public String toString() {
        return "\nProduct: " +
                "\nproductName='" + productName + '\'' +
                "\nproductDescription='" + productDescription + '\'' +
                "\nproductPrice=" + productPrice +
                "\nproductCount=" + productCount;
    }

    public Product(Builder builder){
        this.productName = builder.productName;
        this.productDescription = builder.productDescription;
        this.productPrice = builder.productPrice;
        this.productCount = builder.productCount;
    }

    public static class Builder{
        private String productName;
        private String productDescription;
        private int productPrice;
        private int productCount;

        public Builder(String productName){
            this.productName=productName;
        }

        public Builder setProductDescription(String productDescription){
            this.productDescription = productDescription;
            return this;
        }

        public Builder setProductPrice(int productPrice){
            this.productPrice = productPrice;
            return this;
        }

        public Builder setProductCount(int productCount){
            this.productCount = productCount;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }
}
