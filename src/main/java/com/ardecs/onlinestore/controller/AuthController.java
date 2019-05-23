package com.ardecs.onlinestore.controller;

import com.ardecs.onlinestore.config.WebSecurityConfiguration;
import com.ardecs.onlinestore.entity.RegUser;
import com.ardecs.onlinestore.entity.User;
import com.ardecs.onlinestore.repository.UserJpaRepository;
import com.ardecs.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Objects;

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
        System.out.println("********************************************** GET ******************************************");
        ModelAndView modelAndView = new ModelAndView("authorization");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    //
    @PostMapping("/authorization")
    public @ResponseBody ModelAndView authorizationUser(String username, String password) {
        System.out.println("********************************************** POST ******************************************");
        ModelAndView modelAndView = new ModelAndView("redirect:home");
//////        //modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView getRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView registrationUser(@Validated @ModelAttribute("user")RegUser regUser, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("redirect:home");

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("errorMessage", "Ошибка при регистрации, повторите попытку");
            modelAndView.setViewName("registration");

        } else {
            userService.register(regUser);
        }
        return modelAndView;
    }

//    @GetMapping("/logout")
//    public ModelAndView getLogout() {
//        ModelAndView modelAndView = new ModelAndView("redirect:authorization");
//        //todo - оборвать сессию
//        modelAndView.addObject("user", new User());
//        return modelAndView;
//    }

}
