package com.trilect.service;

import com.trilect.entity.Student;
import com.trilect.model.StudentModel;
import com.trilect.repository.ProjectRepository;
import com.trilect.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository userRepository;
    @Autowired
    private ProjectRepository roleRepository;


    public ResponseEntity<Object> createUser(StudentModel model) {
        Student stud = new Student();
        if (userRepository.findByEmail(model.getEmail()).isPresent()) {
            System.out.println("The email is already present");
            return ResponseEntity.badRequest().body("The Email is already Present, Failed to Create new User");
        } else {
            stud.setFirstName(model.getFirstName());
            stud.setLastName(model.getLastName());
            stud.setMobile(model.getMobile());
            stud.setEmail(model.getEmail());
             stud.setProject(model.getProject());

            Student student = userRepository.save(stud);
            if (userRepository.findById(student.getId()).isPresent())
                return ResponseEntity.ok("User Created Successfully");
            else return ResponseEntity.unprocessableEntity().body("Failed Creating User as Specified");
        }
    }


}
























//    public UserModel getUser(Long id) {
//        User user = userRepository.findById(id).get();
//        UserModel model = new UserModel();
//        model.setFirstName(user.getFirstName());
//        model.setLastName(user.getLastName());
//        model.setMobile(user.getMobile());
//        model.setEmail(user.getEmail());
//        Role newRole = new Role();
//        newRole.setName(user.getRole().getName());
//        newRole.setDescription(user.getRole().getDescription());
//        model.setRole(newRole);
//        return model;
//    }
