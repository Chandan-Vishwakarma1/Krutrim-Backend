package com.krutrim.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentRequestDto {

    private String courseName;
    @NotBlank(message = "Name can not be null or blank")
    private String name;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Please provide a valid email address")
    private String email;
    @NotBlank(message = "Phone number is mandatory")
    private String phone;
    private String mode;
    private String message;
}
