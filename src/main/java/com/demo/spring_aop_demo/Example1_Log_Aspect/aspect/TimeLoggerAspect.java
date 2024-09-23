package com.demo.spring_aop_demo.Example1_Log_Aspect.aspect;

import com.demo.spring_aop_demo.Example1_Log_Aspect.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Aspect
@Component
@Slf4j
public class TimeLoggerAspect {

    //pointcut -> location where we want to point/start the aspect
    @Pointcut("execution(* com.demo.spring_aop_demo.Example1_Log_Aspect.controller.*.*(..))")  //execute point for a particular place in controller class
//    @Pointcut("within(com.demo.spring_aop_demo.Example1.controller.*)") //within - exceute point for a particular type of class within package
//    @Pointcut("this(com.demo.spring_aop_demo.Example1.controller.EmployeeController)") //this - execute point for a particular class
    public void timeLoggerPointCut() {
    }

    @Pointcut("execution(* com.demo.spring_aop_demo.Example1_Log_Aspect.controller.EmployeeController.addEmployee(..))")
    public void addEmployeePointCut() {
    }

    @Before("timeLoggerPointCut()")
    @Order(1)   // Lower order means this will execute first
    public void logTimeBeforeExecution(JoinPoint joinPoint) {   //JoinPoint - contains information about the method being called at the time of execution - [It is a point in the execution of a program where advice (e.g., @Before, @After, etc.) is applied.]
        log.info("Before Timestamp: {}", new Timestamp(System.currentTimeMillis()));
//        joinPoint.getArgs();
    }

    @After("timeLoggerPointCut()")
    public void logTimeAfterExecution(JoinPoint joinPoint) {
        log.info("After Timestamp: {}", new Timestamp(System.currentTimeMillis()));
    }


    @Before("addEmployeePointCut()")
    @Order(2) // Higher order means this will execute second
    public void logArgumentsBeforeExecution(JoinPoint joinPoint) {
        // Get the method arguments
        Object[] args = joinPoint.getArgs();

        // Assuming the first argument is the Employee object (passed in @RequestBody)
        if (args.length > 0 && args[0] instanceof Employee) {
            Employee employee = (Employee) args[0];
            log.info("Adding employee with details: Name={}, Address={}", employee.getFirstName()+" "+employee.getLastName(),employee.getAddress());
        }
    }
}
