package com.ardecs.onlinestore.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {

    private String login;
    private String password;
    private String name;
    private boolean isAdmin;

}
