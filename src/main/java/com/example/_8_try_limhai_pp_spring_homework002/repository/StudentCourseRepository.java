package com.example._8_try_limhai_pp_spring_homework002.repository;

import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentCourseRepository {

    @Insert("""
        INSERT INTO student_course(student_id, course_id)
        VALUES(#{studentId}, #{courseId})
    """)
    void insertStudentCourse(@Param("studentId") Integer studentId,
                             @Param("courseId") Integer courseId);

    @Select("""
    DELETE FROM student_course
    WHERE student_id = #{studentId}
""")
    void deleteStudentCourses(Integer studentId);
}