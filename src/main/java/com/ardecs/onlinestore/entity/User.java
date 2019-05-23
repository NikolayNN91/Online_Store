package com.ardecs.onlinestore.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @Column(name = "login")
    @NotNull
    private String login;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "user_name")
    private String name;

    @Column(name = "is_admin")
    private byte isAdmin;

    public User() {
    }

    public User(String login, String password, String name, byte isAdmin) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.isAdmin = isAdmin;
    }
}
