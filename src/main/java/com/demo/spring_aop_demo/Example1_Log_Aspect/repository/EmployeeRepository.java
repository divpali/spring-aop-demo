package com.demo.spring_aop_demo.Example1_Log_Aspect.repository;

import com.demo.spring_aop_demo.Example1_Log_Aspect.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
