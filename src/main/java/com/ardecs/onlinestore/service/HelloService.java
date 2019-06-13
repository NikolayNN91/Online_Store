package com.ardecs.onlinestore.service;

import com.ardecs.onlinestore.config.WebSecurityConfiguration;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Getter
@Component
public class HelloService {

    @Autowired
    WebSecurityConfiguration.CurrentUser currentUser;

    private static String helloMessage = "Hello, guest!";

    public String getHelloMessage() {
        if (currentUser.getUser() instanceof UserDetails) {
            helloMessage = "Hello, " + ((UserDetails) currentUser.getUser()).getUsername() + "!";
        }
        return helloMessage;
    }
}
