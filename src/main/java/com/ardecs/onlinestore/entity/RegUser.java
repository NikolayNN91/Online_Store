package com.ardecs.onlinestore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegUser {

    @Id
    @Size(min = 3, max = 20, message = "Логин должен содержать от 3-ти до 20-ти символов")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Логин должен содержать только латинские буквы и цифры")
    @NotNull
    private String login;

    @Size(min = 3, max = 20, message = "Пароль должен содержать от 3-ти до 20-ти символов")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Логин должен содержать только латинские буквы и цифры")
    @NotNull
    private String password;

    @Size(min = 3, max = 20, message = "Логин должен содержать от 3-х до 20-ти символов")
    @Pattern(regexp = "^[A-Za-z0-9\t]+$", message = "Логин должен содержать только латинские буквы и цифры")
    private String name;

    private byte isAdmin;
}
