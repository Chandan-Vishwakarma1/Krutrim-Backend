package com.krutrim.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnquiryResponseDto {
    private String id;
    private String name;
    private String email;
    private String mobile;
    private String message;
    private LocalDateTime createdDate;
}
