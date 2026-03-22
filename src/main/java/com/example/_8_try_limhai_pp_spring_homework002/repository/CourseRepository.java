package com.example._8_try_limhai_pp_spring_homework002.repository;

import com.example._8_try_limhai_pp_spring_homework002.model.entity.Course;
import com.example._8_try_limhai_pp_spring_homework002.model.entity.Instructor;
import com.example._8_try_limhai_pp_spring_homework002.model.request.CourseRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepository {


    @Results(id = "courseMapping", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "instructor.instructorId", column = "instructor_id"),
            @Result(property = "instructor.instructorName", column = "instructor_name"),
            @Result(property = "instructor.email", column = "email")
    })
    @Select("""
            SELECT c.course_id, c.course_name, c.description, i.instructor_id, i.instructor_name, i.email
                    FROM courses c 
                    JOIN instructors i 
                    ON c.instructor_id = i.instructor_id
                    LIMIT #{size}
                    OFFSET (#{page} - 1) * #{size}
            """)
    List<Course> findAllCourses(Integer page, Integer size);


    @ResultMap("courseMapping")
    @Select("""
        SELECT c.course_id, c.course_name, c.description, i.instructor_id, i.instructor_name, i.email
        FROM courses c
        JOIN instructors i
        ON c.instructor_id = i.instructor_id
        WHERE c.course_id = #{courseId}
    """)
    Course findCourseById(Integer courseId);


    @ResultMap("courseMapping")
    @Select("""
        INSERT INTO courses(course_name, description, instructor_id) 
        VALUES (#{req.courseName}, #{req.description}, #{req.instructorId})
        RETURNING *;
        """)
    Course saveCourse(@Param("req") CourseRequest courseRequest);


    @ResultMap("courseMapping")
    @Select("""
        UPDATE courses 
        SET 
            course_name = #{req.courseName},
            instructor_id = #{req.instructorId}
        WHERE course_id = #{courseId}
        RETURNING *;
        """)
    Course updateCourse(Integer courseId, @Param("req") CourseRequest courseRequest);


    @Select("""
        DELETE FROM courses
        WHERE course_id = #{courseId}
        RETURNING *
        """)
    Course deleteCourse(Integer courseId);


    @Results(id = "coursesMapping", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "description", column = "description"),

            @Result(property = "instructor.instructorId", column = "instructor_id"),
            @Result(property = "instructor.instructorName", column = "instructor_name"),
            @Result(property = "instructor.email", column = "email")
    })

    @Select("""
        SELECT 
            c.course_id, c.course_name, c.description, i.instructor_id, i.instructor_name,i.email
        FROM courses c
        JOIN student_course sc 
            ON c.course_id = sc.course_id
        JOIN instructors i 
            ON c.instructor_id = i.instructor_id
        WHERE sc.student_id = #{studentId}
    """)
    List<Course> findCoursesByStudentId(Integer studentId);



}
