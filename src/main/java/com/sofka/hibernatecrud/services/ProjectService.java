package com.sofka.hibernatecrud.services;


import com.sofka.hibernatecrud.model.Project;
import com.sofka.hibernatecrud.repository.IProjectJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    IProjectJpaRepository projectJpaRepository;

    public ArrayList<Project> obtenerProjects() {
        return (ArrayList<Project>) projectJpaRepository.findAll();
    }

    public Optional<Project> obtenerPorId(Long projectId) {
        return projectJpaRepository.findById(projectId);
    }

    public Project guardarProject(Project project) {
        return projectJpaRepository.save(project);
    }

    public boolean deleteProject(Long id) {
        try {
            projectJpaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getCause());
            return false;
        }
    }
    public String updateProject(Project project, Long id){
        Optional<Project> projectData= projectJpaRepository.findById(id);
        if(projectData.isPresent()){
            Project proyecto= projectData.get();
            proyecto.setName(project.getName());
            projectJpaRepository.save(proyecto);
            return "Proyecto actualizado";

        }
        else{
            return "Proyecto no actualizado";
        }
    }
}
