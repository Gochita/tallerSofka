package com.sofka.hibernatecrud.controller;

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

    @GetMapping(path = "/roleId/{roleId}")
    public Optional<Role> obtenerRolPorId(@PathVariable Long roleId) {
        return roleService.obtenerRolPorId(roleId);
    }
    // http://localhost:8080/role/saveRole
    @PostMapping(path="/saveRole")
    public Role guardarRole(@RequestBody Role role) {
        return this.roleService.guardarRole(role);
    }
    // http://localhost:8080/role/updateRole/{id}
    @PutMapping(path = "/updateRole/{id}")
    public String updateRole(@PathVariable("id") Long id, @RequestBody Role role) {
        return roleService.updateRole(role, id);
    }

    // http://localhost:8080/role/deleteRole/{id}
    @DeleteMapping(path = "/deleteRole/{id}")
    public String deleteRoleById(@PathVariable("id") Long id) {

        boolean flag = this.roleService.deleteRoleById(id);
        if (flag) {
            return "Rol " + id + " eliminado";
        } else {
            return "Rol no eliminado";

        }
    }


}
