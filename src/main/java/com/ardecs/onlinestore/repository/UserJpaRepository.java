package com.ardecs.onlinestore.repository;

import com.ardecs.onlinestore.entity.RegUser;
import com.ardecs.onlinestore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserJpaRepository extends CrudRepository<User, String> {

     User findByLogin(String login);

     @Modifying
     @Query(value = "UPDATE users SET password = ?1 WHERE login = ?2", nativeQuery = true)
     @Transactional
     int updatePasswordByLogin(String password, String login);

}
