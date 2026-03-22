package com.example._8_try_limhai_pp_spring_homework002.controller;

import com.example._8_try_limhai_pp_spring_homework002.model.entity.Student;
import com.example._8_try_limhai_pp_spring_homework002.model.request.StudentRequest;
import com.example._8_try_limhai_pp_spring_homework002.model.response.ApiResponse;
import com.example._8_try_limhai_pp_spring_homework002.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudent(
            @RequestParam Integer page,
            @RequestParam Integer size) {

        List<Student> students = studentService.getAllStudent(page, size);

        if (students != null && !students.isEmpty()) {

            ApiResponse<List<Student>> response = ApiResponse.<List<Student>>builder()
                    .success(true)
                    .message("Get all students successfully")
                    .status(HttpStatus.OK)
                    .payload(students)
                    .timestamp(Instant.now())
                    .build();

            return ResponseEntity.ok(response);
        }

        ApiResponse<List<Student>> response = ApiResponse.<List<Student>>builder()
                .success(false)
                .message("No students found")
                .status(HttpStatus.NOT_FOUND)
                .payload(null)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @GetMapping("{student_id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@RequestParam Integer student_id) {
        if (studentService.getStudentById(student_id) != null) {
            ApiResponse<Student> response = ApiResponse.<Student>builder()
                    .success(true)
                    .message("Get all students successfully")
                    .status(HttpStatus.OK)
                    .payload(studentService.getStudentById(student_id))
                    .timestamp(Instant.now())
                    .build();

            return ResponseEntity.ok(response);
        }
        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .success(false)
                .message("No students found")
                .status(HttpStatus.NOT_FOUND)
                .payload(null)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }



    @DeleteMapping("{student_id}")
    public ResponseEntity<ApiResponse<String>> deleteStudentById(@PathVariable("student_id") Integer studentId) {
        if (studentService.deleteStudentById(studentId) > 0) {
            ApiResponse<String> response = ApiResponse.<String>builder()
                    .success(true)
                    .message("Student deleted successfully")
                    .status(HttpStatus.OK)
                    .payload(String.valueOf(studentService.deleteStudentById(studentId)))
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.ok(response);
        }
        ApiResponse<String> response = ApiResponse.<String>builder()
                .success(false)
                .message("Student not found")
                .status(HttpStatus.NOT_FOUND)
                .payload(null)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> addStudent(@RequestBody StudentRequest studentRequest){

        Student student = studentService.addStudent(studentRequest);

        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .success(true)
                .status(HttpStatus.CREATED)
                .message("Add student successfully")
                .payload(student)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }



}


