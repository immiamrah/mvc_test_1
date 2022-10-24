package com.example.mvctest_1.controller;

import com.example.mvctest_1.entity.School;
import com.example.mvctest_1.entity.Student;
import com.example.mvctest_1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
     StudentRepository studentRepository;

    @GetMapping("/school/students")
    public List<Student> getStudent(){

        return studentRepository.findAll();
    }

    @GetMapping(value= "/school/students/{id}")
    public Student getStudentById(@PathVariable Long id){

        Student data = studentRepository.findById(id).get();
        return data;
    }
    @GetMapping("/school")
            public School getSchool(){
        List<Student>students =studentRepository.findAll();
        School sc = new School();
        sc.setName("QAFQAZ UNIVERSITETI");
        sc.setStudents(students);
        return sc;
        }

}
