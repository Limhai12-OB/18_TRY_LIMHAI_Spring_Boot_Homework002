package com.example._8_try_limhai_pp_spring_homework002.service.impl;

import com.example._8_try_limhai_pp_spring_homework002.model.entity.Course;
import com.example._8_try_limhai_pp_spring_homework002.model.request.CourseRequest;
import com.example._8_try_limhai_pp_spring_homework002.repository.CourseRepository;
import com.example._8_try_limhai_pp_spring_homework002.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses(Integer page, Integer size) {
        return courseRepository.findAllCourses(page, size);
    }

    @Override
    public Course getCourseById(Integer courseId) {
        return courseRepository.findCourseById(courseId);
    }

    @Override
    public Course addCourse(CourseRequest courseRequest) {
        return courseRepository.saveCourse(courseRequest);
    }

    @Override
    public Course updateCourse(Integer courseId, CourseRequest courseRequest) {
        return courseRepository.updateCourse(courseId, courseRequest);
    }

    @Override
    public Course deleteCourse(Integer courseId) {
        return courseRepository.deleteCourse(courseId);
    }
}
