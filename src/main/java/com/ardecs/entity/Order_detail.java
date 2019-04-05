package com.ardecs.entity;

import lombok.Data;

@Data
public class Order_detail {

    private int product_id;
    private int order_id;
    private int quantity;
}
