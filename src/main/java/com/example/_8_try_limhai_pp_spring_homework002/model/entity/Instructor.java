package com.example._8_try_limhai_pp_spring_homework002.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {

    private Integer instructorId;
    private String instructorName;
    private String email;


}
