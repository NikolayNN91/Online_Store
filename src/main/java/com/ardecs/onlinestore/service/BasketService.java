package com.ardecs.onlinestore.service;

import com.ardecs.onlinestore.entity.Product;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class BasketService {

    final List<Product> productList = new LinkedList<>();

    public void addInBasket(Product product) {
        productList.add(product);
    }

    public void deleteFromBasket(Product product) {
        productList.remove(product);
    }

    public void clearBasket() {
        productList.clear();
    }

    public List<Product> getProductList() {
        return productList;
    }
}
