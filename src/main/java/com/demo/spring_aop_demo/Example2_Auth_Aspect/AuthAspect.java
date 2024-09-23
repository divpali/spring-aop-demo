package com.demo.spring_aop_demo.Example2_Auth_Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthAspect {

    //call the aspect for all different pointcuts for different packages
    @Pointcut("within(com.demo.spring_aop_demo..*)") //within - this defines which particular type of class execute authentication
    public void authenticatingPointCut() {

    }

//    @Pointcut("within(com.demo.spring_aop_demo..*)")
//    public void authorizationPointCut() {
//
//    }

    @Before("authenticatingPointCut()")
    public void authenticate() {
        System.out.println("auth the request");
    }
}
