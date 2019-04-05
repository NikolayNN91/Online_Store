package com.ardecs.entity;

import lombok.Data;

@Data
public class User {

    private String login;
    private String password;
    private String name;
    private boolean isAdmin;

}
