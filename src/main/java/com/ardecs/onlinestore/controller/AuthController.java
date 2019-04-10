package com.ardecs.onlinestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    @GetMapping("/authorization")
    public ModelAndView getAuthorizationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("authorization");

        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView getRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");

        return modelAndView;
    }

}
