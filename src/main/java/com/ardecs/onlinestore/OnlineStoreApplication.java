package com.ardecs.onlinestore;

import com.ardecs.onlinestore.entity.Product;
import com.ardecs.onlinestore.entity.User;
import com.ardecs.onlinestore.repository.ProductJpaRepository;
import com.ardecs.onlinestore.repository.UserJpaRepository;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class OnlineStoreApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OnlineStoreApplication.class, args);

       UserJpaRepository userJpaRepository = context.getBean(UserJpaRepository.class);
       ProductJpaRepository productJpaRepository = context.getBean(ProductJpaRepository.class);


        User user = new User();
        user.setLogin("login1");
        user.setPassword("password1");
        user.setName("name1");
        user.setIsAdmin((byte)0);

        Product product = new Product();
        product.setAmountOfProduct(10);
        product.setType("Notebook");
        product.setPrice(40000);
        product.setManufacturer("ASUS");

        //userJpaRepository.save(user);
        //productJpaRepository.deleteById(1);

    }

}

