package com.ardecs.onlinestore.controller;

import com.ardecs.onlinestore.entity.Order;
import com.ardecs.onlinestore.entity.Product;
import com.ardecs.onlinestore.repository.OrderJpaRepository;
import com.ardecs.onlinestore.repository.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    OrderJpaRepository orderJpaRepository;

    @Autowired
    ProductJpaRepository productJpaRepository;

    @GetMapping
    public ModelAndView getAdminPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hello", "Здравствуй, Хозяин!");
        List<Product> productList = productJpaRepository.findAll();
        modelAndView.addObject(productList);
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @GetMapping("/orders")
    public ModelAndView getOrdersPage() {
        ModelAndView modelAndView = new ModelAndView();
        List<Order> orders = orderJpaRepository.findAll();
        modelAndView.addObject(orders);
        modelAndView.setViewName("orders");
        return modelAndView;
    }

    @GetMapping("/order")
    public ModelAndView getOrderPage(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<Order> order = orderJpaRepository.findById(id);
        modelAndView.addObject("order", order.get());
        modelAndView.setViewName("order");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/order")
    public ModelAndView closeOrder(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        orderJpaRepository.deleteById(id);
        modelAndView.addObject("message", "Заказ обработан и удален из базы данных");
        modelAndView.setViewName("order");
        return modelAndView;
    }

    @GetMapping("/product_change")
    public ModelAndView getProductChangePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product_change");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/product_change")
    public ModelAndView productAdd(Product product) {
        ModelAndView modelAndView = new ModelAndView();
        productJpaRepository.save(product);
        modelAndView.addObject("message", "Новый продукт добавлен в общий список продуктов");
        modelAndView.setViewName("product_change");
        return modelAndView;
    }

    @PostMapping("/product_update")
    public ModelAndView productChange(Product product) {
        ModelAndView modelAndView = new ModelAndView();
        productJpaRepository.save(product);
        modelAndView.addObject("message", "Продукт" + product.getId() + "обновлен");
        modelAndView.setViewName("product_update");
        return modelAndView;
    }

}
