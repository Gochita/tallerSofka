package com.sofka.hibernatecrud.services;


import com.sofka.hibernatecrud.model.Employee;
import com.sofka.hibernatecrud.repository.IEmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeJpaRepository employeeJpaRepository;



    public ArrayList<Employee> obtenerEmployees(){
        return (ArrayList<Employee>) employeeJpaRepository.findAll();
    }

    public Employee obtenerPorId(String employeeId){
        return employeeJpaRepository.findByEmployeeId(employeeId);
    }

    public Employee guardarEmployee(Employee employee){
        return employeeJpaRepository.save(employee);
    }


}
