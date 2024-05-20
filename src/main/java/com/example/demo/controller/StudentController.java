package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.error.StudentNotFoundException;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudentById(@PathVariable("id") Long studentId) {
        studentService.deleteStudentById(studentId);
        return "deleted";
    }

    @PutMapping("/student/{id}")
    public Student updateStudentById(@PathVariable("id") Long studentId, @RequestBody Student student) throws StudentNotFoundException {
        return studentService.updateStudentById(studentId, student);
    }

    @GetMapping("/student/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") Long studentId) throws StudentNotFoundException {
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/student")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
