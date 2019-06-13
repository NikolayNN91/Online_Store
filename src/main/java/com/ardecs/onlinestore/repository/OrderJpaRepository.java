package com.ardecs.onlinestore.repository;

import com.ardecs.onlinestore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJpaRepository extends JpaRepository<Order, Integer> {

}
