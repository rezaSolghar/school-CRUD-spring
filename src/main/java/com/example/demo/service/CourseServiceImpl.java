package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.error.CourseNotFoundException;
import com.example.demo.error.StudentNotFoundException;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public Course getCourseByName(Long courseName) {
        return courseRepository.findByName(courseName);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourseById(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public Course updateCourseById(Long courseId, Course course) throws CourseNotFoundException {
        Course courDB = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Course not available!"));
        if (Objects.nonNull(course.getName()) && !"".equalsIgnoreCase(course.getName())) {
            courDB.setName(course.getName());
        }
        return courseRepository.save(courDB);
    }
}
