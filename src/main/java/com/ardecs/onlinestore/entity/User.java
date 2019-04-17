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
    @Size(min=6, max=20, message = "Логин должен содержать от 6-ти до 20-ти символов")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Логин должен содержать только латинские буквы и цифры")
    @NotNull
    private String login;

    @Column(name = "password")
    @Size(min=6, max=20, message = "Пароль должен содержать от 6-ти до 20-ти символов")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Логин должен содержать только латинские буквы и цифры")
    @NotNull
    private String password;

    @Column(name = "user_name")
    @Size(min=3, max=20, message = "Логин должен содержать от 3-х до 20-ти символов")
    @Pattern(regexp = "^[A-Za-z0-9\t]+$", message = "Логин должен содержать только латинские буквы и цифры")
    private String name;

    @Column(name = "is_admin")
    private byte isAdmin;

    public User() {
    }

}
