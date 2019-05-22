package com.ardecs.onlinestore.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    public ModelAndView notFoundException(NotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ModelAndView notFoundException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView illegalArgumentException(IllegalArgumentException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EmptyListException.class)
    public ModelAndView emptyProductListInBasketException(EmptyListException ex) {
        ModelAndView modelAndView = new ModelAndView("myBasket");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }
}
