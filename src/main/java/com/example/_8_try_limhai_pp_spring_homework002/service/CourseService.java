package com.example._8_try_limhai_pp_spring_homework002.service;

import com.example._8_try_limhai_pp_spring_homework002.model.entity.Course;
import com.example._8_try_limhai_pp_spring_homework002.model.request.CourseRequest;

import java.util.List;


public interface CourseService {
    List<Course> getAllCourses(Integer page, Integer size);

    Course getCourseById(Integer courseId);

    Course addCourse(CourseRequest courseRequest);

    Course updateCourse(Integer courseId, CourseRequest courseRequest);

    Course deleteCourse(Integer courseId);
}
