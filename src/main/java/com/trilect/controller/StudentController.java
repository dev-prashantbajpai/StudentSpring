package com.trilect.controller;

import com.trilect.entity.Student;
import com.trilect.model.StudentModel;
import com.trilect.repository.StudentRepository;
import com.trilect.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentService userService;
    private StudentRepository userRepository;

    public StudentController(StudentService userService, StudentRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/student/create")
    public ResponseEntity<Object> createUser(@RequestBody StudentModel studentModel) {
        return userService.createUser(studentModel);
    }
    @GetMapping("/student/details/{id}")
    public Student getUser(@PathVariable Long id) {
        if(userRepository.findById(id).isPresent())
        return userRepository.findById(id).get();
        else return  null;
    }
    @GetMapping("/student/all")
    public List<Student> getUsers() {
        return userRepository.findAll();
    }


}
