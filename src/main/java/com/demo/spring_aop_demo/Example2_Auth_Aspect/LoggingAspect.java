package com.demo.spring_aop_demo.Example2_Auth_Aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.demo.spring_aop_demo.Example2_Auth_Aspect.ShoppingCart.checkout(..))")
    public void beforeLogger() {
        System.out.println("Before loggers");
    }

    @After("execution(* com.demo.spring_aop_demo.Example2_Auth_Aspect.ShoppingCart.checkout(..))")
    public void afterLogger() {
        System.out.println("After loggers");
    }

}
