package com.sofka.hibernatecrud.controller;

import com.sofka.hibernatecrud.model.Project;
import com.sofka.hibernatecrud.model.Role;
import com.sofka.hibernatecrud.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping
    public ArrayList<Role> obtenerRole() {
        return roleService.obtenerRoles();
    }

    @GetMapping(path = "/roleId")
    public Optional<Role> obtenerRolPorId(@PathVariable Long roleId) {
        return roleService.obtenerRolPorId(roleId);
    }

    @PostMapping
    public Role guardarRole(@RequestBody Role role) {
        return this.roleService.guardarRole(role);
    }


}
