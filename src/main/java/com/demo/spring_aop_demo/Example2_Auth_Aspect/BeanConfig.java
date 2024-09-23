package com.demo.spring_aop_demo.Example2_Auth_Aspect;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.demo.spring_aop_demo")
@EnableAspectJAutoProxy
public class BeanConfig {


}
