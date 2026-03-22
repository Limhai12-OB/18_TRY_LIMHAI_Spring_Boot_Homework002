package com.example._8_try_limhai_pp_spring_homework002.controller;

import com.example._8_try_limhai_pp_spring_homework002.model.entity.Course;
import com.example._8_try_limhai_pp_spring_homework002.model.entity.Instructor;
import com.example._8_try_limhai_pp_spring_homework002.model.request.CourseRequest;
import com.example._8_try_limhai_pp_spring_homework002.model.response.ApiResponseCourse;
import com.example._8_try_limhai_pp_spring_homework002.model.response.ApiResponseInstructor;
import com.example._8_try_limhai_pp_spring_homework002.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<ApiResponseCourse<List<Course>>> getAllCourses(@RequestParam Integer page, @RequestParam Integer size){
        List<Course> courses = courseService.getAllCourses(page,size);
        if (courses != null && !courses.isEmpty()){
            ApiResponseCourse<List<Course>> responseCourse = ApiResponseCourse.<List<Course>>builder()
                        .success(true)
                        .message("Get all instructors successfully")
                        .status(HttpStatus.OK)
                        .payload(courses)
                        .timestamp(Instant.now())
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(responseCourse);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("{course_id}")
    public ResponseEntity<ApiResponseCourse<Course>> getCourseById(@PathVariable Integer course_id){
        if (courseService.getCourseById(course_id) != null){
            ApiResponseCourse<Course> responseCourse = ApiResponseCourse.<Course>builder()
                    .success(true)
                    .message("Get course successfully")
                    .status(HttpStatus.OK)
                    .payload(courseService.getCourseById(course_id))
                    .timestamp(Instant.now())
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(responseCourse);
        }

        ApiResponseCourse<Course> response = ApiResponseCourse.<Course>builder()
                .success(false)
                .message("Course not found")
                .status(HttpStatus.NOT_FOUND)
                .payload(null)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @PostMapping()
    public ResponseEntity<ApiResponseCourse<Course>> addCourse(@RequestBody CourseRequest courseRequest){
        if (courseService.addCourse(courseRequest) != null){
            ApiResponseCourse<Course> responseCourse = ApiResponseCourse.<Course>builder()
                    .success(true)
                    .message("Added course successfully")
                    .status(HttpStatus.OK)
                    .payload(courseService.addCourse(courseRequest))
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.CREATED).body(responseCourse);
        }
        ApiResponseCourse<Course> responseCourse = ApiResponseCourse.<Course>builder()
                .success(false)
                .message("Added Course failed")
                .status(HttpStatus.NOT_FOUND)
                .payload(null)
                .timestamp(Instant.now())
                .build();
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseCourse);
    }

    @PutMapping("{course_id}")
    public ResponseEntity<ApiResponseCourse<Course>> updateCourse(@PathVariable Integer course_id, @RequestBody CourseRequest courseRequest){
        if(courseService.updateCourse(course_id, courseRequest) != null ){
            ApiResponseCourse<Course> responseCourse = ApiResponseCourse.<Course>builder()
                    .success(true)
                    .message("Course Updated")
                    .status(HttpStatus.OK)
                    .payload(courseService.updateCourse(course_id, courseRequest))
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(responseCourse);
        }
        ApiResponseCourse<Course> responseCourse = ApiResponseCourse.<Course>builder()
                .success(false)
                .message("Course Update failed")
                .status(HttpStatus.BAD_REQUEST)
                .payload(null)
                .timestamp(Instant.now())
                .build();
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseCourse);
    }

    @DeleteMapping("{course_id}")
    public Course deleteCourse(@PathVariable Integer course_id){
        return courseService.deleteCourse(course_id);
    }

}
