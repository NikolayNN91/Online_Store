package com.ardecs.onlinestore.service;

import com.ardecs.onlinestore.entity.Order;
import com.ardecs.onlinestore.entity.Product;
import com.ardecs.onlinestore.entity.User;
import com.ardecs.onlinestore.exception.EmptyListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class BasketService {

    final Set<Product> productList = new HashSet<>();

    @Autowired
    private ProductService productService;

    public void addInBasket(Product product) {
            productList.add(product);
    }

    public void deleteFromBasket(Product product) {
        productList.remove(product);
    }

    public void clearBasket() {
        productList.clear();
    }

    public Set<Product> getProductList() {
        return productList;
    }

    public Order orderMapping(Set<Product> productList, User user) {
        if(productList.isEmpty()) {
            throw new EmptyListException("Вы не добавили продукты в корзину");
        }
        int sumPrice = 0;
        Order order = new Order();
        order.setProductSet(productList);
        order.setUser(user);
        order.setDate(Date.from(Instant.now()));
        for(Product product : productList) {
           sumPrice =+ product.getPrice();
        }
        order.setPrice(sumPrice);

        return order;
    }
}
