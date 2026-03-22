package com.example._8_try_limhai_pp_spring_homework002.model.request;

import com.example._8_try_limhai_pp_spring_homework002.model.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    private String studentName;
    private String email;
    private String phoneNumber;
    private List<Integer> courseId;


}
