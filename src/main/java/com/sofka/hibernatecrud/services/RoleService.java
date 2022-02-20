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

    public Optional<Role> obtenerRolPorId(Long roleId) {
        return roleJpaRepository.findById(roleId);
    }

    public Role guardarRole(Role role) {
        return roleJpaRepository.save(role);
    }

    public String updateRole(Role role, Long id){
        Optional<Role> roleData= roleJpaRepository.findById(id);
        if(roleData.isPresent()){
            Role rol= roleData.get();
            rol.setName(role.getName());
            roleJpaRepository.save(rol);
            return "Rol "+ id+ " actualizado";
        }else{
            return "Rol no actualizado";
        }
    }

    public boolean deleteRoleById(Long id){
        try{
            roleJpaRepository.deleteById(id);
            return true;
        }catch(Exception e){
            System.out.println(e.getCause());
            return false;
        }
    }




}
