package com.ardecs.onlinestore.controller;

import com.ardecs.onlinestore.entity.Order;
import com.ardecs.onlinestore.entity.Product;
import com.ardecs.onlinestore.service.OrderService;
import com.ardecs.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @GetMapping
    public ModelAndView getAdminPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hello", "Привет, Хозяин!");
        List<Product> productList = productService.findAll();
        modelAndView.addObject(productList);
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @GetMapping("/orders")
    public ModelAndView getOrdersPage() {
        ModelAndView modelAndView = new ModelAndView();
        List<Order> orders = orderService.findAll();
        modelAndView.addObject("orders", orders);
        modelAndView.setViewName("orders");
        return modelAndView;
    }

    @GetMapping("/order")
    public ModelAndView getOrderPage(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView("order");
        Order order = orderService.findById(id);
        modelAndView.addObject("order", order);
        return modelAndView;
    }

    @PostMapping("/order")
    public ModelAndView closeOrder(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        orderService.deleteById(id);
        modelAndView.addObject("message", "Заказ обработан и удален из базы данных");
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @GetMapping("/product_add")
    public ModelAndView getProductAddPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product_add");
        return modelAndView;
    }

    @GetMapping("/product_update")
    public ModelAndView getProductChangePage(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id", id);
        modelAndView.setViewName("product_update");
        return modelAndView;
    }

    @PostMapping("/product_add")
    public ModelAndView productAdd(Product product) {
        ModelAndView modelAndView = new ModelAndView();
        productService.save(product);
        modelAndView.addObject("message", "Продукт " + product.getId() + " добавлен");
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @PostMapping("/product_update")
    public ModelAndView productChange(Product product) {
        ModelAndView modelAndView = new ModelAndView();
        productService.save(product);
        modelAndView.addObject("message", "Продукт " + product.getId() + " обновлен");
        modelAndView.setViewName("admin");
        return modelAndView;
    }

}
