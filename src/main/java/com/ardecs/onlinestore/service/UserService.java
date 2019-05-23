package com.ardecs.onlinestore.service;

import com.ardecs.onlinestore.entity.RegUser;
import com.ardecs.onlinestore.entity.User;
import com.ardecs.onlinestore.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Transactional(noRollbackFor = Exception.class)
    public void register(RegUser regUser) {

        String encoderPassword = passwordEncoder.encode(regUser.getPassword());
        User user = new User(regUser.getLogin(), encoderPassword, regUser.getName(), regUser.getIsAdmin());

        if (userJpaRepository.existsById(user.getLogin())) {
            throw new IllegalArgumentException("User already registered");
        }

        regUser.setPassword(encoderPassword);
        userJpaRepository.save(user);
    }
}
