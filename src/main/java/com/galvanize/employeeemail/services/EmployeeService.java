package com.galvanize.employeeemail.services;

import com.galvanize.employeeemail.models.Employee;
import com.galvanize.employeeemail.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createAnEmployee(Employee employee){
        return  employeeRepository.save(employee);
    }
}
