package com.ardecs.onlinestore.controller;

import com.ardecs.onlinestore.config.WebSecurityConfiguration;
import com.ardecs.onlinestore.entity.Order;
import com.ardecs.onlinestore.entity.Product;
import com.ardecs.onlinestore.entity.User;
import com.ardecs.onlinestore.repository.ProductJpaRepository;
import com.ardecs.onlinestore.repository.UserJpaRepository;
import com.ardecs.onlinestore.service.BasketService;
import com.ardecs.onlinestore.service.HelloService;
import com.ardecs.onlinestore.service.OrderService;
import com.ardecs.onlinestore.service.ProductService;
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
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private WebSecurityConfiguration.CurrentUser currentUser;

    @Autowired
    private BasketService basketService;

    @Autowired
    private HelloService helloService;

    @GetMapping({"/home", "/"})
    public ModelAndView getHomePage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("helloMessage", helloService.getHelloMessage());
        List<Product> productList = productService.findAll();
        modelAndView.addObject(productList);
        modelAndView.setViewName("home");
        return modelAndView;
    }

    //@Secured(value={"1", "0"})
    @GetMapping("/myBasket")
    public ModelAndView getBasketPage(){
        ModelAndView modelAndView = new ModelAndView("myBasket");
        Set<Product> productList = basketService.getProductList();
        modelAndView.addObject(productList);
        return modelAndView;
    }

    @PostMapping("/myBasket")
    public ModelAndView addProductInBasket(@RequestParam("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.findById(id);
        basketService.addInBasket(product);
        modelAndView.addObject("user", currentUser.getUser());
        modelAndView.setViewName("redirect:myBasket");
        return modelAndView;
    }

    @GetMapping("/product")
    public ModelAndView getProductPage(@RequestParam("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.findById(id);
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

    @PostMapping("/myBasket/pay")
    public ModelAndView payProductInBasket(Set<Product> productList, User user){
        ModelAndView modelAndView = new ModelAndView("myBasket");
        Order order = basketService.orderMapping(productList, user);
        orderService.save(order);
        basketService.clearBasket();
        modelAndView.addObject("successMessage", "Заказ сформирован и оплачен");
        return modelAndView;
    }

//    @GetMapping("/error")
//    public ModelAndView getErrorPage(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("error");
//        modelAndView.addObject("errorMessage", );
//        return modelAndView;
//    }
}

