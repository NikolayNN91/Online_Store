package com.ardecs.onlinestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public ModelAndView getAdminPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @GetMapping("/orders")
    public ModelAndView getOrdersPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orders");
        return modelAndView;
    }

    @GetMapping("/order")
    public ModelAndView getOrderPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("order");
        return modelAndView;
    }

    @GetMapping("/product_change")
    public ModelAndView getProductChangePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product_change");
        return modelAndView;
    }
}
