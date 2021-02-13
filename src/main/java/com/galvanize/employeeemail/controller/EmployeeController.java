package com.galvanize.employeeemail.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.employeeemail.models.Employee;
import com.galvanize.employeeemail.services.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee createAnEmployee(@RequestBody Employee employee) throws Exception{

            return employee;
    }



}
