package com.myblog.myblog11;

public class Product {
    private long id;
    private String productName;
    private String productType;

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public double getPrice() {
        return price;
    }

    private double price;

    public Product(long id, String productName, String productType, double price) {
        this.id = id;
        this.productName = productName;
        this.productType = productType;
        this.price = price;
    }
}
