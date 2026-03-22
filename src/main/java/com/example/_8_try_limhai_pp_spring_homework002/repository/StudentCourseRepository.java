//package com.example._8_try_limhai_pp_spring_homework002.repository;
//
//import com.example._8_try_limhai_pp_spring_homework002.model.entity.Course;
//import org.apache.ibatis.annotations.*;
//
//import java.util.List;
//
//@Mapper
//public interface StudentCourseRepository {
//    @Results(id = "mapper" , value = {
//            @Result(property = "courseName" , column = "course_name"),
//            @Result(property = "instructorId" , column = "instructor_id"),
//            @Result(property = "instructor" , column = "instructor_id",
//                    one = @One(select = "com.example._8_try_limhai_pp_spring_homework002.repository.InstructorRepository.getInstructorById")
//            )
//    })
//    @Select("""
//    SELECT c.* FROM courses c
//    JOIN student_course sc ON sc.course_id = c.course_id
//    WHERE sc.student_id = #{studentId}
//""")
//    @ResultMap("mapper")
//    List<Course> findCoursesByStudentId(Long studentId);
//
//
//    @ResultMap("mapper")
//    @Insert("""
//    INSERT INTO student_course(student_id, course_id)
//    VALUES (#{studentId}, #{courseId})
//""")
//    void saveStudentCourse(Long studentId , Long courseId);
//
//}
