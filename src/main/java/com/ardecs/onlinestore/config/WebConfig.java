//package com.ardecs.onlinestore.config;//package com.ardecs.onlinestore.config;
//
//import com.ardecs.onlinestore.controller.AuthController;
//import com.ardecs.onlinestore.repository.UserJpaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.support.BasicAuthorizationInterceptor;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = { "com.ardecs.onlinestore.controller" })
//public class WebConfig implements WebMvcConfigurer {
//
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.jsp().prefix("/WEB-INF/views/").suffix(".jsp");
//    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/test").setViewName("test");
//    }
//}
