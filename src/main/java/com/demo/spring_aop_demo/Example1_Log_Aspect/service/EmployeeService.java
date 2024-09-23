package com.demo.spring_aop_demo.Example1_Log_Aspect.service;

import com.demo.spring_aop_demo.Example1_Log_Aspect.entity.Employee;
import com.demo.spring_aop_demo.Example1_Log_Aspect.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


}
