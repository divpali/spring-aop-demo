package com.demo.spring_aop_demo.Example1_Log_Aspect.controller;

import com.demo.spring_aop_demo.Example1_Log_Aspect.service.EmployeeService;
import com.demo.spring_aop_demo.Example1_Log_Aspect.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/emp")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
        log.info("Fetching employee with id {}", id);

        Optional<Employee> employee = employeeService.getEmployeeById(id);

        if (employee.isPresent()) {
            log.info("Employee found: {}", employee.get());
            return ResponseEntity.ok(employee.get());
        } else {
            log.warn("Employee with id {} not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
//        log.info("Add employee {}", employee);

        Employee createdEmployee = employeeService.addEmployee(employee);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        log.info("Fetching all employees");

        List<Employee> employees = employeeService.getAllEmployees();

        if (employees.isEmpty()) {
            log.info("No employees found");
            return ResponseEntity.noContent().build();  // Returns 204 No Content if no employees exist
        } else {
            log.info("Found {} employees", employees.size());
            return ResponseEntity.ok(employees);
        }
    }


    @GetMapping("/emp/error")
    public Object throwException() {
        log.info("Throwing random exception");
        throw new RuntimeException("Some random exception");
    }
}

