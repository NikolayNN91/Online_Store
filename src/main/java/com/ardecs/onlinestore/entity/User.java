package com.ardecs.onlinestore.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

//@Component
@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "user_name")
    private String name;

    @Column(name = "is_admin")
    private byte isAdmin;

    public User() {
    }

}
