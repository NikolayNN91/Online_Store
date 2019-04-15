package com.ardecs.onlinestore.service;

import com.ardecs.onlinestore.entity.Order;
import com.ardecs.onlinestore.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    public Order mappingOrder() {
        Order order = new Order();
        return order;
    }
}
