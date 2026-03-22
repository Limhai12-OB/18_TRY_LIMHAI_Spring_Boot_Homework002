package com.example._8_try_limhai_pp_spring_homework002.service;

import com.example._8_try_limhai_pp_spring_homework002.model.entity.Instructor;
import com.example._8_try_limhai_pp_spring_homework002.model.request.InstructorRequest;

import java.util.List;


public interface InstructorService {

    List<Instructor> getAllInstructors(Integer page, Integer size);

    Instructor getInstructorById(Integer instructorId);

    Instructor updateInstructor(Integer instructor_id, InstructorRequest instructorRequest);

    Instructor addInstructor(InstructorRequest instructorRequest);

    Instructor deleteInstructor(Integer instructorId);
}
