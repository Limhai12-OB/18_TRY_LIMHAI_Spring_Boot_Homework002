package com.example._8_try_limhai_pp_spring_homework002.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentCourseRepository {

    @Insert("""
        INSERT INTO student_course(student_id, course_id)
        VALUES(#{studentId}, #{courseId})
    """)
    void insertStudentCourse(@Param("studentId") Integer studentId,
                             @Param("courseId") Integer courseId);
}