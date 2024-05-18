package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.error.CourseNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    public List<Course> getAllCourses();

    public Optional<Course> getCourseById(Long courseId);

    public Course getCourseByName(Long courseName);

    public Course saveCourse(Course course);

    public void deleteCourseById(Long courseId);

    public Course updateCourseById(Long courseId, Course course) throws CourseNotFoundException;
}
