package com.ardecs.onlinestore;

import com.ardecs.onlinestore.controller.HomeController;
import com.ardecs.onlinestore.entity.Order;
import com.ardecs.onlinestore.entity.Product;
import com.ardecs.onlinestore.entity.User;
import com.ardecs.onlinestore.repository.OrderJpaRepository;
import com.ardecs.onlinestore.repository.ProductJpaRepository;
import com.ardecs.onlinestore.repository.UserJpaRepository;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//@ComponentScan(basePackageClasses= HomeController.class)
@ComponentScan(basePackages = "com.ardecs.onlinestore.controller")
public class OnlineStoreApplication {

    public static void main(String[] args) {
     ConfigurableApplicationContext context = SpringApplication.run(OnlineStoreApplication.class, args);

//     UserJpaRepository userJpaRepository = context.getBean(UserJpaRepository.class);
//     ProductJpaRepository productJpaRepository = context.getBean(ProductJpaRepository.class);
//     OrderJpaRepository orderJpaRepository = context.getBean(OrderJpaRepository.class);
//
//
//        User user = new User();
//        user.setLogin("login2");
//        user.setPassword("password2");
//        user.setName("name2");
//        user.setIsAdmin((byte)0);
//
//        userJpaRepository.save(user);
//
//        Product product = new Product();
//        product.setAmountOfProduct(20);
//        product.setType("Notebook3");
//        product.setPrice(60000);
//        product.setManufacturer("ASUS3");
//
//        productJpaRepository.save(product);
//
//        Product product2 = new Product();
//        product2.setAmountOfProduct(40);
//        product2.setType("Notebook4");
//        product2.setPrice(70000);
//        product2.setManufacturer("ASUS4");
//
//        productJpaRepository.save(product2);
//
//        Order order = new Order();
//        order.setPrice(40000);
//        Date date = new Date();
//        order.setDate(date);
//        order.setUser(user);
//        Set<Product> set = new HashSet<>();
//        set.add(product);
//        set.add(product2);
//        order.setProductSet(set);
//
//     orderJpaRepository.deleteAll();
//     userJpaRepository.deleteAll();
//     productJpaRepository.deleteAll();
//
//        order=orderJpaRepository.save(order);
//        System.out.println(order);



    }

}

