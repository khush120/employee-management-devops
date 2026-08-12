package com.employee;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public String getEmployee() {
        return "Employee API - Developer A + Developer B Updated";
    }

    public String getEmployeeUpdate() {
        return "Updated Employee Service";
    }
}