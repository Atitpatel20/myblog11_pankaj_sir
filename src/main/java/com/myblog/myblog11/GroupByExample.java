package com.myblog.myblog11;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByExample {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1, "cushion", "home", 367.0),
                new Product(2, "belt", "fashion", 100.0),
                new Product(3, "charger", "electronic", 250.0),
                new Product(4, "googles", "fashion", 170.0),
                new Product(5, "sofa", "home", 22500.0),
                new Product(6, "bluetoothEearPhone", "electronic", 367.0)

        );
        Map<String, List<Product>> collect = products.stream().collect(Collectors.groupingBy(str -> str.getProductType()));

        for ( Map.Entry<String,List<Product>> entry: collect.entrySet()) {
            String productType = entry.getKey();
            List<Product> productList = entry.getValue();
            System.out.println("product_type: "+productType+"----");
            for ( Product p: productList) {
                System.out.println(p.getId());
                System.out.println(p.getProductName());
                System.out.println(p.getPrice());
            }

        }

    }
}
