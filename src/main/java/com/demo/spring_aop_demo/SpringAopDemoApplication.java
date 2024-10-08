package com.demo.spring_aop_demo;

import com.demo.spring_aop_demo.Example2_Auth_Aspect.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringAopDemoApplication implements CommandLineRunner {

	@Autowired
	ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(SpringAopDemoApplication.class, args);
	}

	public void run(String... args) throws Exception {
		ShoppingCart cart = context.getBean(ShoppingCart.class);
		System.out.println("here1");
		cart.checkout("CANCELLED");
	}

}
