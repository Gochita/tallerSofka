package com.sofka.hibernatecrud.services;


import com.sofka.hibernatecrud.model.Employee;
import com.sofka.hibernatecrud.repository.IEmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeJpaRepository employeeJpaRepository;


    public ArrayList<Employee> obtenerEmployees() {
        return (ArrayList<Employee>) employeeJpaRepository.findAll();
    }

    public Employee obtenerPorId(String employeeId) {
        return employeeJpaRepository.findByEmployeeId(employeeId);
    }

    public Employee guardarEmployee(Employee employee) {
        return employeeJpaRepository.save(employee);
    }

    public String updateEmployee(Employee employee, Long id) {
        Optional<Employee> employeeData = employeeJpaRepository.findById(id);
        if (employeeData.isPresent()) {
            Employee empleado = employeeData.get();
            empleado.setFirstName(employee.getFirstName());
            empleado.setLastName(employee.getLastName());
            empleado.setEmployeeId(employee.getEmployeeId());
            empleado.setRole(employee.getRole());
            employeeJpaRepository.save(empleado);
            return "Empleado actualizado";
        } else {
            return "Empleado no encontrado";
        }

    }

    public Boolean deleteEmployee(Long id) {
        try {
            employeeJpaRepository.deleteById(id);
            return true;
        } catch (Exception b) {
            System.out.println(b.getCause());
            return false;
        }

    }


}
