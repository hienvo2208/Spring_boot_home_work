package com.example.demo.controller;

import com.example.demo.Entity.Student;
import com.example.demo.model.CreateStudent;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody CreateStudent createStudent){
      studentService.createUser(createStudent);
      return ResponseEntity.ok("thanh cong");
    }

    @GetMapping("")
    public ResponseEntity<?> getListUser(){
        List<Student> studentList = studentService.getListStudents();
        return ResponseEntity.ok(studentList);
    }
}
