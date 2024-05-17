package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.error.StudentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student saveStudent(Student student);

    public void deleteStudentById(Long studentId);

    public Student updateStudentById(Long studentId, Student student) throws StudentNotFoundException;

    public Optional<Student> getStudentById(Long studentId) throws StudentNotFoundException;

    public List<Student> getAllStudents();
}
