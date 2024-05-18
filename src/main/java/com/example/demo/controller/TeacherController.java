package com.example.demo.controller;

import com.example.demo.entity.Teacher;
import com.example.demo.error.TeacherNotFoundException;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teacher")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/teacher/{id}")
    public Optional<Teacher> getAllTeachers(@PathVariable("id") Long teacherId) throws TeacherNotFoundException {
        return teacherService.getTeacherById(teacherId);
    }

    @PostMapping("/teacher")
    public Teacher saveTeacher(@RequestBody Teacher teacher) {
        return teacherService.saveTeacher(teacher);
    }

    @PutMapping("/teacher/{id}")
    public Teacher updateTeacher(@PathVariable("id") Long teacherId,
                                 @RequestBody Teacher teacher) throws TeacherNotFoundException {
        return teacherService.updateTeacher(teacherId,teacher);
    }

    @DeleteMapping("teacher/{id}")
    public String deleteTeacher(@PathVariable("id") Long teacherId) {

        teacherService.deleteTeacher(teacherId);
        return "deleted";
    }

}
