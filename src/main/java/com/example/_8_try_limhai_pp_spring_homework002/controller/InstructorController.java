package com.example._8_try_limhai_pp_spring_homework002.controller;

import com.example._8_try_limhai_pp_spring_homework002.model.entity.Instructor;
import com.example._8_try_limhai_pp_spring_homework002.model.request.InstructorRequest;
import com.example._8_try_limhai_pp_spring_homework002.model.response.ApiResponseInstructor;
import com.example._8_try_limhai_pp_spring_homework002.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorService instructorService;


    @GetMapping
    public ResponseEntity<ApiResponseInstructor<List<Instructor>>> getAllInstructors(
            @RequestParam Integer page,
            @RequestParam Integer size) {

        List<Instructor> instructors = instructorService.getAllInstructors(page, size);

        if (instructors != null && !instructors.isEmpty()) {

            ApiResponseInstructor<List<Instructor>> response = ApiResponseInstructor.<List<Instructor>>builder()
                    .success(true)
                    .message("Get all instructors successfully")
                    .status(HttpStatus.OK)
                    .payload(instructors)
                    .timestamp(Instant.now())
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("{instructor_id}")
    public ResponseEntity<ApiResponseInstructor<Instructor>> getInstructorById(@PathVariable Integer instructor_id){
        if(instructorService.getInstructorById(instructor_id) != null){
            ApiResponseInstructor<Instructor> response = ApiResponseInstructor.<Instructor>builder()
                    .success(true)
                    .message("Get all instructors successfully")
                    .status(HttpStatus.OK)
                    .payload(instructorService.getInstructorById(instructor_id))
                    .timestamp(Instant.now())
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        ApiResponseInstructor<Instructor> response = ApiResponseInstructor.<Instructor>builder()
                .success(false)
                .message("no")
                .status(HttpStatus.NOT_FOUND)
                .payload(null)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @PutMapping("{instructor_id}")
    public ResponseEntity<ApiResponseInstructor<Instructor>> updateInstructor(@PathVariable Integer instructor_id, @RequestBody InstructorRequest instructorRequest){
        if(instructorService.updateInstructor(instructor_id, instructorRequest) != null){
            ApiResponseInstructor<Instructor> response = ApiResponseInstructor.<Instructor>builder()
                    .success(true)
                    .message("Update instructors successfully")
                    .status(HttpStatus.OK)
                    .payload(instructorService.updateInstructor(instructor_id, instructorRequest))
                    .timestamp(Instant.now())
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        ApiResponseInstructor<Instructor> response = ApiResponseInstructor.<Instructor>builder()
                .success(false)
                .message("Update not successfully")
                .status(HttpStatus.NOT_FOUND)
                .payload(null)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }


    @PostMapping
    public ResponseEntity<ApiResponseInstructor<Instructor>> addInstructor(@RequestBody InstructorRequest instructorRequest){

        Instructor instructor = instructorService.addInstructor(instructorRequest);

        if (instructor != null) {
            ApiResponseInstructor<Instructor> response = ApiResponseInstructor.<Instructor>builder()
                    .success(true)
                    .message("Add instructor successfully")
                    .status(HttpStatus.CREATED)
                    .payload(instructor)
                    .timestamp(Instant.now())
                    .build();

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        ApiResponseInstructor<Instructor> response = ApiResponseInstructor.<Instructor>builder()
                .success(false)
                .message("Add instructor not successfully")
                .status(HttpStatus.BAD_REQUEST)
                .payload(null)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }



    @DeleteMapping("{instructor_id}")
    public Instructor deleteInstructor(@PathVariable Integer instructor_id){
        return instructorService.deleteInstructor(instructor_id);
    }

}
