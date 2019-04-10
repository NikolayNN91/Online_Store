package com.ardecs.onlinestore.repository;

import com.ardecs.onlinestore.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCrudRepository extends CrudRepository<User, Integer> {

}
