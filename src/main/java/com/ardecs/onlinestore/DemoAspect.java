//package com.ardecs.onlinestore;
//
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class DemoAspect {
//
//    @Pointcut("execution(* com.ardecs.onlinestore.repository.UserJpaRepository.save(..))")
//    public void pointcut() {}
//
//    @Before("pointcut()")
//    public void before() {
//        System.out.println("Before method save************************************************************************");
//    }
//
//    @After("pointcut()")
//    public void after() {
//        System.out.println("After method save**************************************************************************");
//    }
//}
