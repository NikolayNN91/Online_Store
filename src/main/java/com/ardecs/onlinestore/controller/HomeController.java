package com.ardecs.onlinestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/home")
    public ModelAndView getHomePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping("/myBasket")
    public ModelAndView getBasketPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("myBasket");
        return modelAndView;
    }

    @GetMapping("/product")
    public ModelAndView getProductPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product");
        return modelAndView;
    }

    @GetMapping("/contacts")
    public ModelAndView getContactsPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("contacts");
        return modelAndView;
    }
}

