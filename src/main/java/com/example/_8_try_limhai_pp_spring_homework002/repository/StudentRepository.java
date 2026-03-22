package com.example._8_try_limhai_pp_spring_homework002.repository;

import com.example._8_try_limhai_pp_spring_homework002.model.entity.Course;
import com.example._8_try_limhai_pp_spring_homework002.model.entity.Student;
import com.example._8_try_limhai_pp_spring_homework002.model.request.StudentRequest;
import com.example._8_try_limhai_pp_spring_homework002.model.response.ApiResponse;
import org.apache.ibatis.annotations.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Results(id = "studentMapping", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNumber", column = "phone_number"),

            @Result(
                    property = "courses",
                    column = "student_id",
                    many = @Many(
                            select = "com.example._8_try_limhai_pp_spring_homework002.repository.CourseRepository.findCoursesByStudentId"
                    )
            )
    })

    @Select("""
            SELECT *
            FROM students
            LIMIT #{size}
            OFFSET (#{page} - 1) * #{size}
        """)
    List<Student> findAllStudent(
            @Param("page") Integer page,
            @Param("size") Integer size
    );


    @ResultMap("studentMapping")
    @Select("""
        SELECT * FROM students
        WHERE student_id = #{studentId}
        """)
    Student getStudentById(Integer studentId);

    @Delete("""
        DELETE FROM students
        WHERE student_id = #{studentId}
        """)
    int deleteStudentById(Integer studentId);


    @Select("""
        INSERT INTO students(student_name,email,phone_number)
        VALUES(#{studentName},#{email},#{phoneNumber})
        RETURNING student_id
    """)
    Integer insertStudent(Student student);

    @ResultMap("studentMapping")
    @Select("""
        SELECT * FROM students
        WHERE student_id = #{studentId}
    """)
    Student findStudentById(Integer studentId);



}
