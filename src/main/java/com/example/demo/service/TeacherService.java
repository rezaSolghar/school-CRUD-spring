package com.example.demo.service;

import com.example.demo.entity.Teacher;
import com.example.demo.error.TeacherNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TeacherService {


    public List<Teacher> getAllTeachers();

    public Optional<Teacher> getTeacherById(Long teacherId) throws TeacherNotFoundException;


    public Teacher saveTeacher(Teacher teacher);

    public Teacher updateTeacher(Long teacherId, Teacher teacher) throws TeacherNotFoundException;

    public void deleteTeacher(Long teacherId);

}
