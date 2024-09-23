package com.demo.spring_aop_demo.Example2_Auth_Aspect;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

    public void checkout(String status) {

        //logging
        //auth
        //sanitize data
        System.out.println("Checkout method from shopping cart called");
    }
}
