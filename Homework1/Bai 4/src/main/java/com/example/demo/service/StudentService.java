package com.example.demo.service;

import com.example.demo.Entity.Student;
import com.example.demo.model.CreateStudent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public void createUser(CreateStudent createStudent);
    public List<Student> getListStudents();
}
