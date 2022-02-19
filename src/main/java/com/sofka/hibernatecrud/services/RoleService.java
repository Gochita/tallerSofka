package com.sofka.hibernatecrud.services;

import com.sofka.hibernatecrud.model.Role;
import com.sofka.hibernatecrud.repository.IRoleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    IRoleJpaRepository roleJpaRepository;


    public ArrayList<Role> obtenerRoles() {
        return (ArrayList<Role>) roleJpaRepository.findAll();
    }

    public Optional<Role> obtenerRolPorId(Long roletId) {
        return roleJpaRepository.findById(roletId);
    }

    public Role guardarRole(Role role) {
        return roleJpaRepository.save(role);
    }


}
