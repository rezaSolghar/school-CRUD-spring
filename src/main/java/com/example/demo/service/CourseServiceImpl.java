package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Teacher;
import com.example.demo.error.CourseNotFoundException;
import com.example.demo.error.TeacherNotFoundException;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TeacherRepository teacherRepository;


    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }



    @Override
    public Course getCourseByName(String courseName) {
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

    @Override
    public Course addingTeacherToCourse(String courseName, String teacherName) throws TeacherNotFoundException, CourseNotFoundException {
        Teacher teacher = teacherRepository.findByName(teacherName);
        if (teacher == null) {
            throw new TeacherNotFoundException("Teacher not found with name: " + teacherName);
        }
        Course course = courseRepository.findByName(courseName);
        if (course == null) {
            throw new CourseNotFoundException("Course not found with name: " + courseName);
        }
        course.setTeacher(teacher);

        return courseRepository.save(course);


    }


}
