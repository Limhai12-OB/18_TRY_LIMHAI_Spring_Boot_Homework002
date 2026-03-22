package com.example._8_try_limhai_pp_spring_homework002.repository;

import com.example._8_try_limhai_pp_spring_homework002.model.entity.Instructor;
import com.example._8_try_limhai_pp_spring_homework002.model.request.InstructorRequest;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface InstructorRepository {

    @Results(id = "instructorMapper", value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name")
    })
    @Select("SELECT * FROM instructors")
    List<Instructor> findAllInstructor(Integer page, Integer size);


    @ResultMap("instructorMapper")
    @Select("""
        SELECT * FROM instructors
        WHERE instructor_id = #{instructorId}
    """)
    Instructor findInstructorById(Integer instructorId);


    @ResultMap("instructorMapper")
    @Select("""
    UPDATE instructors
    SET instructor_name = #{req.instructorName},
        email = #{req.email}
    WHERE instructor_id = #{instructorId}
    RETURNING *;
""")
    Instructor updateInstructor( Integer instructorId, @Param("req") InstructorRequest instructorRequest);


    @ResultMap("instructorMapper")
    @Select("""
        INSERT INTO instructors(instructor_name, email)
        VALUES (#{req.instructorName}, #{req.email})
        RETURNING *;
        """)
    Instructor addInstructor(@Param("req") InstructorRequest instructorRequest);


    @ResultMap("instructorMapper")
    @Select("""
        DELETE FROM instructors
        WHERE instructor_id = #{instructorId}
        RETURNING *;
     """)
    Instructor deleteInstructor(Integer instructorId);
}
