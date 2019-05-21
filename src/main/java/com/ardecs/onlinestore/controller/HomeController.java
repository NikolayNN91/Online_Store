package com.ardecs.onlinestore.controller;

import com.ardecs.onlinestore.config.WebSecurityConfiguration;
import com.ardecs.onlinestore.entity.Product;
import com.ardecs.onlinestore.repository.ProductJpaRepository;
import com.ardecs.onlinestore.repository.UserJpaRepository;
import com.ardecs.onlinestore.service.BasketService;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Autowired
    private WebSecurityConfiguration.CurrentUser currentUser;

    @Autowired
    private BasketService basketService;

    @GetMapping({"/home", "/"})
    public ModelAndView getHomePage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", currentUser.getUser());
        List<Product> productList = productJpaRepository.findAll();
        modelAndView.addObject(productList);
        modelAndView.setViewName("home");
        return modelAndView;
    }

    //@Secured(value={"1", "0"})
    @GetMapping("/myBasket")
    public ModelAndView getBasketPage(){
        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = basketService.getProductList();
        modelAndView.addObject(productList);
        modelAndView.setViewName("myBasket");
        return modelAndView;
    }

    @PostMapping("/myBasket")
    public ModelAndView addProductInBasket(@RequestParam("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        Product product = productJpaRepository.findById(id).get();
        basketService.addInBasket(product);
        return modelAndView;
    }

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

