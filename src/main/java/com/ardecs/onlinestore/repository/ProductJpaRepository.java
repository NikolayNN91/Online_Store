package com.ardecs.onlinestore.repository;

import com.ardecs.onlinestore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Integer> {

//    @Modifying
//    @Query(value = "UPDATE products SET password = ?1 WHERE id = ?", nativeQuery = true)
//    @Transactional
//    public void updateProductById(int id);
}