package com.trilect.service;

import com.trilect.entity.Project;
import com.trilect.repository.ProjectRepository;
import com.trilect.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private ProjectRepository roleRepository;

    private StudentRepository userRepository;

    public ProjectService(ProjectRepository roleRepository, StudentRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    /** Create a new role along with users */
    public ResponseEntity<Object> addRole(Project role)  {

        Project newRole = new Project();
        newRole.setName(role.getName());
        newRole.setDuration(role.getDuration());
        newRole.setStudents(role.getStudents());
        Project savedRole = roleRepository.save(newRole);
        if(roleRepository.findById(savedRole.getId()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully Created  and Users");
        } else
            return ResponseEntity.unprocessableEntity().body("Failed to Create specified Role");
    }


    /** Delete a specified role given the id */
    public ResponseEntity<Object> deleteRole(Long id) {
        if(roleRepository.findById(id).isPresent()){
            roleRepository.deleteById(id);
            if(roleRepository.findById(id).isPresent()){
                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
            } else return ResponseEntity.ok().body("Successfully deleted specified record");
        } else
            return ResponseEntity.unprocessableEntity().body("No Records Found");
    }

}



