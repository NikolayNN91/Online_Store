package com.ardecs.onlinestore.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
//@Component
@Entity
@Table(name = "Orders")
public class Order {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "price")
    private int price;

    @Column(name = "date")
    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "Orders_details",
                joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private Set<Product> productSet;

    public Order() {}
}
