package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api41")
public class ApiController {
    @Autowired
    private StudentService studentservice;

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent() {
        return studentservice.getAllStudents();
    }

    @GetMapping("/getById/{id}")
    public Optional<Student> getStudentById(@PathVariable int id) {
        return studentservice.getStudentById(id);
    }

    @PostMapping("/addStudent")
    public boolean addStudent(@RequestBody Student student) {
        return studentservice.addStudent(student);
    }

    @GetMapping("/getByDepartment/{department}")
    public List<Student> getStudentBydepartment(@PathVariable String department) {
        return studentservice.getStudentByDepartment(department);
    }

    // New API to delete a student by ID
    @DeleteMapping("/deleteById/{id}")
    public String deleteStudentById(@PathVariable int id) {
        boolean isDeleted = studentservice.deleteStudentById(id);
        if (isDeleted) {
            return "Student with ID " + id + " deleted successfully.";
        } else {
            return "Student with ID " + id + " not found.";
        }
    }
}
