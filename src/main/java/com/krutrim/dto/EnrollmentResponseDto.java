package com.krutrim.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentResponseDto {

    private String id;
    private String courseName;
    private String name;
    private String email;
    private String phone;
    private String profession;
    private String mode;
    private LocalDateTime createdDate;

}