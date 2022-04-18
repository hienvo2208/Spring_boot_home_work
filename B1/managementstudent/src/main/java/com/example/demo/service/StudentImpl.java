package com.example.demo.service;

import com.example.demo.Entity.Student;
import com.example.demo.model.CreateStudent;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class StudentImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public void createUser(CreateStudent createStudent) {
        Student  student= new Student();
        student.setName(createStudent.getName());
        student.setGrade(createStudent.getGrade());
        studentRepository.save(student);
    }

    @Override
    public List<Student> getListStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }
}
