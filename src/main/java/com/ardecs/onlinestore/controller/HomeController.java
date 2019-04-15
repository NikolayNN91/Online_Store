package com.ardecs.onlinestore.controller;

import com.ardecs.onlinestore.entity.Product;
import com.ardecs.onlinestore.repository.ProductJpaRepository;
import com.ardecs.onlinestore.repository.UserJpaRepository;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserJpaRepository userJpaRepository;

    @Autowired
    ProductJpaRepository productJpaRepository;

    @GetMapping("/home")
    public ModelAndView getHomePage(){
        ModelAndView modelAndView = new ModelAndView();
        List<Product> prductList = productJpaRepository.findAll();
        modelAndView.addObject(prductList);
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping("/myBasket")
    public ModelAndView getBasketPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("myBasket");
        return modelAndView;
    }

//    @GetMapping("/product")
//    public ModelAndView getProductPage(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("product");
//        return modelAndView;
//    }

    @GetMapping("/product")
    public ModelAndView getProductPage(@RequestParam("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        Product product = productJpaRepository.findById(id).get();
        modelAndView.addObject("product", product);
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

