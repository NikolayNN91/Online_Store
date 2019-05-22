package com.ardecs.onlinestore.service;

import com.ardecs.onlinestore.entity.Order;
import com.ardecs.onlinestore.exception.NotFoundException;
import com.ardecs.onlinestore.repository.OrderJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderJpaRepository orderJpaRepository;

    public Order findById(int id) {
        return orderJpaRepository.findById(id).orElseThrow(() -> new NotFoundException("Order not found"));
    }

    public List<Order> findAll() {

        return orderJpaRepository.findAll();
    }

    public void deleteById(int id) {
        orderJpaRepository.deleteById(id);
    }

    public void save(Order order) {
        orderJpaRepository.save(order);
    }
}
