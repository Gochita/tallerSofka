package com.sofka.hibernatecrud.controller;


import com.sofka.hibernatecrud.model.Employee;
import com.sofka.hibernatecrud.model.Project;
import com.sofka.hibernatecrud.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @GetMapping
    public ArrayList<Project> obtenerProjects() {
        return projectService.obtenerProjects();
    }

    @GetMapping(path="/projectId")
    public Optional<Project> obtenerProjectPorId(@PathVariable Long projectId) {
        return projectService.obtenerPorId(projectId);
    }

    @PostMapping
    public Project guardarProject(@RequestBody Project project) {
        return this.projectService.guardarProject(project);
    }

}
