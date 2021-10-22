  package com.trilect.controller;

import com.trilect.entity.Project;
import com.trilect.repository.ProjectRepository;
import com.trilect.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    private ProjectService projectService;
    private ProjectRepository projectRepository;
    public ProjectController(ProjectService projectService, ProjectRepository projectRepository) {
        this.projectService = projectService;
        this.projectRepository = projectRepository;
    }
    @PostMapping("/project/create")
    public ResponseEntity<Object> createRole(@RequestBody Project project) {
            return projectService.addRole(project);
    }
    @DeleteMapping("/project/delete/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
        return projectService.deleteRole(id);
    }
    @GetMapping("/project/details/{id}")
    public Project getRole(@PathVariable Long id) {
        if(projectRepository.findById(id).isPresent())
        return projectRepository.findById(id).get();
        else return null;
    }
    @GetMapping("/project/all")
    public List<Project> getRoles() {
        return projectRepository.findAll();
    }

}




