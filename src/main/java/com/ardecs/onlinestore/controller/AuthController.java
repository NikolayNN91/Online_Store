package com.ardecs.onlinestore.controller;

import com.ardecs.onlinestore.config.WebSecurityConfiguration;
import com.ardecs.onlinestore.entity.RegUser;
import com.ardecs.onlinestore.entity.User;
import com.ardecs.onlinestore.repository.UserJpaRepository;
import com.ardecs.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private WebSecurityConfiguration.CustomUserDetailService userDetailsService;


    @GetMapping("/authorization")
    public ModelAndView getAuthorizationPage() {
        ModelAndView modelAndView = new ModelAndView("authorization");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }


    @PostMapping("/authorization")
    public @ResponseBody
    ModelAndView authorizationUser(String username, String password) {
        ModelAndView modelAndView = new ModelAndView("redirect:home");
        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView getRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView registrationUser(@Validated @ModelAttribute("user") RegUser regUser, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("redirect:home");

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");

        } else {
            userService.register(regUser);
        }
        return modelAndView;
    }
}
