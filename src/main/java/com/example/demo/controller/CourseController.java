package com.example.demo.controller;

import com.example.demo.dto.AddTeacherToCourseRequest;
import com.example.demo.entity.Course;
import com.example.demo.error.CourseNotFoundException;
import com.example.demo.error.TeacherNotFoundException;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/course/{id}")
    public Optional<Course> getCourseById(@PathVariable("id") Long courseId) {
        return courseService.getCourseById(courseId);
    }

    @GetMapping("/course/{name}")
    public Course getCourseByName(@PathVariable("name") String courseName) {
        return courseService.getCourseByName(courseName);
    }

    @PostMapping("/course")
    public Course saveCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @DeleteMapping("/course/{id}")
    public String deleteCourseById(@PathVariable("id") Long courseId) {
        courseService.deleteCourseById(courseId);
        return "deleted";
    }

    @PutMapping("/course/{id}")
    public Course updateCourseById(@PathVariable("id") Long courseId
            , @RequestBody Course course) throws CourseNotFoundException {
        return courseService.updateCourseById(courseId, course);
    }

    @PostMapping("course/addTeacher")
    public Course addingTeacherToCourse(@RequestBody AddTeacherToCourseRequest request)
            throws TeacherNotFoundException, CourseNotFoundException {
        return courseService.addingTeacherToCourse(request.getCourseName(), request.getTeacherName());
    }
}
