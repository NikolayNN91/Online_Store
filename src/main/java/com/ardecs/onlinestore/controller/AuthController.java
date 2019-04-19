package com.ardecs.onlinestore.controller;

import com.ardecs.onlinestore.entity.User;
import com.ardecs.onlinestore.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Objects;

@Controller
public class AuthController {

    @Autowired
    UserJpaRepository userJpaRepository;


    @GetMapping("/authorization")
    public ModelAndView getAuthorizationPage() {
        ModelAndView modelAndView = new ModelAndView("authorization");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/authorization")
    public ModelAndView authorizationUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView getRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView registrationUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("redirect:authorization");

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("errorMessage", "Ошибка при регистрации, повторите попытку");
            modelAndView.setViewName("registration");

//            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//            System.out.println(((BeanPropertyBindingResult) bindingResult.getModel().get("org.springframework.validation.BindingResult.user")).getFieldErrors().get(1).getDefaultMessage() + "*****************");
//            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        } else {
            userJpaRepository.save(user);
        }
        return modelAndView;
    }

}
