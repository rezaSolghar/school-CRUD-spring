package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddTeacherToCourseRequest {

    private String courseName;
    private String teacherName;

}
