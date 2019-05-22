package com.ardecs.onlinestore.service;

import com.ardecs.onlinestore.entity.User;
import com.ardecs.onlinestore.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    public void save(User user) {
        userJpaRepository.save(user);
    }

    public void updatePasswordByLogin(String encoderPassword, String login) {
        userJpaRepository.updatePasswordByLogin(encoderPassword, login);
    }
}
