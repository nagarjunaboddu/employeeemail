package com.galvanize.employeeemail.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.employeeemail.models.Employee;
import com.galvanize.employeeemail.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createAnEmployee(@RequestBody Employee employee) throws Exception{
       return this.employeeService.createAnEmployee(employee);
    }

    @GetMapping
    public List<Employee> listAllEmployees(){
        return  employeeService.listAllEmployees();

    }



}
