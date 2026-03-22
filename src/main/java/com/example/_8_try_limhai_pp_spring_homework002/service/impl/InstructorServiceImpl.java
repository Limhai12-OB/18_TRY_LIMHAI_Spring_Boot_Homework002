package com.example._8_try_limhai_pp_spring_homework002.service.impl;

import com.example._8_try_limhai_pp_spring_homework002.model.entity.Instructor;
import com.example._8_try_limhai_pp_spring_homework002.model.request.InstructorRequest;
import com.example._8_try_limhai_pp_spring_homework002.repository.InstructorRepository;
import com.example._8_try_limhai_pp_spring_homework002.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;




    @Override
    public List<Instructor> getAllInstructors(Integer page, Integer size) {
        return instructorRepository.findAllInstructor(page,size);
    }

    @Override
    public Instructor getInstructorById(Integer instructorId) {
        return instructorRepository.findInstructorById(instructorId);
    }

    @Override
    public Instructor updateInstructor(Integer instructor_id, InstructorRequest instructorRequest) {
        return (Instructor) instructorRepository.updateInstructor(instructor_id, instructorRequest);
    }

    @Override
    public Instructor addInstructor(InstructorRequest instructorRequest) {
        return instructorRepository.addInstructor(instructorRequest);
    }

    @Override
    public Instructor deleteInstructor(Integer instructorId) {
        return instructorRepository.deleteInstructor(instructorId);
    }
}
