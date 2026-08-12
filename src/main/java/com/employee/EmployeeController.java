package com.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/")
    public String home() {
        return "Employee Management Application is Running!";
    }

    @GetMapping("/employees")
    public String employees() {
        return "Employee API is working!";
    }
}