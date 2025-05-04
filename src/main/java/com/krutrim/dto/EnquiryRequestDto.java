package com.krutrim.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnquiryRequestDto {
    @NotBlank(message = "Name can not be blank or empty")
    private String name;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Please provide a valid email address")
    private String email;
    @NotBlank(message = "Phone number is mandatory")
    private String mobile;
    private String message;

}
