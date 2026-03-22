package com.example._8_try_limhai_pp_spring_homework002.service;

import com.example._8_try_limhai_pp_spring_homework002.model.entity.Student;
import com.example._8_try_limhai_pp_spring_homework002.model.request.StudentRequest;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent(Integer page, Integer size);

    Student getStudentById(Integer studentId);

    int deleteStudentById(Integer studentId);

    Student addStudent(StudentRequest studentRequest);

    Student updateStudent (Integer studentId, StudentRequest studentRequest);

}
