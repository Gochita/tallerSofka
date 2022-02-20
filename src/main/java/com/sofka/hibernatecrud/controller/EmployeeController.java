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
    // http://localhost:8080/employee/employeeId/{employeeId}
    @GetMapping(path="/employeeId/{employeeId}")
    public Employee obtenerEmployeePorId(@PathVariable String employeeId) {
        return employeeService.obtenerPorId(employeeId);
    }


    // http://localhost:8080/employee/saveEmployee
    @PostMapping(path="/saveEmployee")
    public Employee guardarEmployee(@RequestBody Employee employee) {
        return this.employeeService.guardarEmployee(employee);
    }

    // http://localhost:8080/employee/employeeDelete/{id}
    @DeleteMapping("/employeeDelete/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id){
        boolean flag= this.employeeService.deleteEmployee(id);
        if(flag){
            return "Empleado "+ id+ " eliminado";
        }else{
            return "Empleado no eliminado";
        }
    }

    // http://localhost:8080/employee/employeeUpdate/{id}
    @PutMapping("/employeeUpdate/{id}")
    public String updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(employee,id);
    }


}
