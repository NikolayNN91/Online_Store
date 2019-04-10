package com.ardecs.onlinestore.repository;


import org.springframework.beans.factory.annotation.Autowired;

public class UserCrudRepositoryImpl {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public void sout(int id) {
       // System.out.println(userCrudRepository.save());
    }

}
