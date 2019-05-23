package com.ardecs.onlinestore.service;

import com.ardecs.onlinestore.config.WebSecurityConfiguration;
import com.ardecs.onlinestore.entity.Order;
import com.ardecs.onlinestore.entity.Product;
import com.ardecs.onlinestore.entity.User;
import com.ardecs.onlinestore.exception.EmptyListException;
import com.ardecs.onlinestore.repository.UserJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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

    @Autowired
    private UserJpaRepository userJpaRepository;


    @Autowired
    private WebSecurityConfiguration.CurrentUser currentUser;

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

    public Order orderMapping() {

        if(productList.isEmpty()) {
            throw new EmptyListException("Вы не добавили продукты в корзину");
        }
        int sumPrice = 0;

        Order order = new Order();
        order.setProductSet(productList);
        order.setUser(userJpaRepository.findByLogin(((UserDetails)currentUser.getUser()).getUsername()));
        order.setDate(Date.from(Instant.now()));
        for(Product product : productList) {
           sumPrice += product.getPrice();
        }
        order.setPrice(sumPrice);

        return order;
    }
}
