package com.ardecs.onlinestore.repository;

import com.ardecs.onlinestore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends CrudRepository<User, String> {

     User findByLogin(String login);

}
