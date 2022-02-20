package com.sofka.hibernatecrud.controller;

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

    //http://localhost:8080/project
    @GetMapping
    public ArrayList<Project> obtenerProjects() {
        return projectService.obtenerProjects();
    }



    //http://localhost:8080/project/{id}
    @GetMapping(path="/{projectId}")
    public Optional<Project> obtenerProjectPorId(@PathVariable Long projectId) {
        return projectService.obtenerPorId(projectId);
        //si devuelve null significa que no hay proyectos existentes con ese id
    }

    //http://localhost:8080/project
    @PostMapping
    public Project guardarProject(@RequestBody Project project) {
        return this.projectService.guardarProject(project);
    }

    //http://localhost:8080/project/projectUpdate/{id}
    @PutMapping(path="/projectUpdate/{id}")
    public String updateProject(@PathVariable("id") Long id, @RequestBody Project project) {
        return projectService.updateProject(project, id);
    }
    //http://localhost:8080/project/deleteProject/{id}
    @DeleteMapping("/deleteProject/{id}")
    public String deleteProjectById(@PathVariable("id") Long id){
        boolean flag= this.projectService.deleteProject(id);
        if(flag){
            return "Proyecto "+ id+ " eliminado";
        }
        else{
            return "Proyecto no eliminado";
        }
    }

}
