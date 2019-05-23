package com.ardecs.onlinestore.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    public ModelAndView notFoundException(NotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ModelAndView notFoundException(Exception ex) {
        LOG.error("Unhandled exception: ", ex);

        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView illegalArgumentException(IllegalArgumentException ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EmptyListException.class)
    public ModelAndView emptyProductListInBasketException(EmptyListException ex) {
        ModelAndView modelAndView = new ModelAndView("myBasket");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(AccessDeniedException.class)
    public ModelAndView accessDeniedException(AccessDeniedException ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", ex.getMessage());
        return modelAndView;
    }
}
