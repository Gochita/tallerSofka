package com.sofka.hibernatecrud.controller;


import com.sofka.hibernatecrud.model.Employee;
import com.sofka.hibernatecrud.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    @GetMapping
    public ArrayList<Employee> obtenerEmployees() {
        return employeeService.obtenerEmployees();
    }

    @GetMapping(path="/employeeId")
    public Employee obtenerEmployeePorId(@PathVariable String employeeId) {
        return employeeService.obtenerPorId(employeeId);
    }

    @PostMapping
    public Employee guardarEmployee(@RequestBody Employee employee) {
        return this.employeeService.guardarEmployee(employee);
    }


}
