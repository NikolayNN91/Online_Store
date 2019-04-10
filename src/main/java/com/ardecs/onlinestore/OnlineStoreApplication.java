package com.ardecs.onlinestore;

import com.ardecs.onlinestore.repository.UserCrudRepositoryImpl;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class OnlineStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineStoreApplication.class, args);

        UserCrudRepositoryImpl userCrudRepository = new UserCrudRepositoryImpl();
        userCrudRepository.sout(0);

    }

}

