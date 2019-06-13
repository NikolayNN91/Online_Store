package com.ardecs.onlinestore.service;

import com.ardecs.onlinestore.entity.Product;
import com.ardecs.onlinestore.exception.NotFoundException;
import com.ardecs.onlinestore.repository.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductJpaRepository productJpaRepository;

    public Product findById(int id) {
        return productJpaRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found"));
    }

    public List<Product> findAll() {
        return productJpaRepository.findAll();
    }

    public void save(Product product) {
        productJpaRepository.save(product);
    }
}
