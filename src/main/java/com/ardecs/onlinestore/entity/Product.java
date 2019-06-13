package com.ardecs.onlinestore.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private int price;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "amount_of_product")
    private int amountOfProduct;

    public Product() {
    }

}
