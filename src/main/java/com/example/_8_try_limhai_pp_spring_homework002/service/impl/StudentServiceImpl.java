package com.example._8_try_limhai_pp_spring_homework002.service.impl;

import com.example._8_try_limhai_pp_spring_homework002.model.entity.Student;
import com.example._8_try_limhai_pp_spring_homework002.model.request.StudentRequest;
import com.example._8_try_limhai_pp_spring_homework002.repository.StudentCourseRepository;
import com.example._8_try_limhai_pp_spring_homework002.repository.StudentRepository;
import com.example._8_try_limhai_pp_spring_homework002.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;

    @Override
    public List<Student> getAllStudent(Integer page, Integer size) {
        return studentRepository.findAllStudent(page, size);
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.getStudentById(studentId);
    }

    @Override
    public int deleteStudentById(Integer studentId) {
        return studentRepository.deleteStudentById(studentId);
    }


    @Override
    public Student addStudent(StudentRequest studentRequest) {

        Student student = new Student();
        student.setStudentName(studentRequest.getStudentName());
        student.setEmail(studentRequest.getEmail());
        student.setPhoneNumber(studentRequest.getPhoneNumber());

        Integer studentId = studentRepository.insertStudent(student);

        if(studentRequest.getCourseId() != null){
            studentRequest.getCourseId().forEach(courseId ->
                    studentCourseRepository.insertStudentCourse(studentId, courseId));
        }

        return studentRepository.findStudentById(studentId);
    }



}
