package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.error.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student updateStudentById(Long studentId, Student student) throws StudentNotFoundException {
        Student stuDB = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not available!"));
        if (Objects.nonNull(student.getFirstName()) && !"".equalsIgnoreCase(student.getFirstName())) {
            stuDB.setFirstName(student.getFirstName());
        }
        if (Objects.nonNull(student.getLastName()) && !"".equalsIgnoreCase(student.getLastName())) {
            stuDB.setLastName(student.getLastName());
        }
        if (Objects.nonNull(student.getEmailId()) && !"".equalsIgnoreCase(student.getEmailId())) {
            stuDB.setEmailId(student.getEmailId());
        }

        return studentRepository.save(stuDB);
    }

    @Override
    public Optional<Student> getStudentById(Long studentId) throws StudentNotFoundException {
        Optional<Student> student = studentRepository.findById(studentId);

        if(student.isEmpty()) {
            throw new StudentNotFoundException("Student not Available!");
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
         return studentRepository.findAll();
    }


}
