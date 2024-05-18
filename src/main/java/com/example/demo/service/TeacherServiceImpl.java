package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.error.StudentNotFoundException;
import com.example.demo.error.TeacherNotFoundException;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> getTeacherById(Long teacherId) throws TeacherNotFoundException {
        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        if(teacher.isEmpty()) {
            throw new TeacherNotFoundException("Teacher not Available!");
        }
        return teacher;
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Long teacherId, Teacher teacher) throws TeacherNotFoundException {
        Teacher teaDB = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new TeacherNotFoundException("Student not available!"));
        if (Objects.nonNull(teacher.getName()) && !"".equalsIgnoreCase(teacher.getName())) {
            teaDB.setName(teacher.getName());
        }
        if (Objects.nonNull(teacher.getEmail()) && !"".equalsIgnoreCase(teacher.getEmail())) {
            teaDB.setEmail(teacher.getEmail());
        }
        return teacherRepository.save(teaDB);
    }

    @Override
    public void deleteTeacher(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }
}
