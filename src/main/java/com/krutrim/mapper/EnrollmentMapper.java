package com.krutrim.mapper;

import com.krutrim.dto.EnrollmentRequestDto;
import com.krutrim.dto.EnrollmentResponseDto;
import com.krutrim.entity.Enrollment;

public class EnrollmentMapper {

    public static Enrollment toEntity(EnrollmentRequestDto dto) {
        Enrollment enrollment = new Enrollment();
        enrollment.setCourseName(dto.getCourseName());
        enrollment.setName(dto.getName());
        enrollment.setEmail(dto.getEmail());
        enrollment.setPhone(dto.getPhone());
        enrollment.setMode(dto.getMode());
        enrollment.setMessage(dto.getMessage());
        return enrollment;
    }

    public static EnrollmentResponseDto toDto(Enrollment enrollment) {
        EnrollmentResponseDto dto = new EnrollmentResponseDto();
        dto.setId(enrollment.getId());
        dto.setCourseName(enrollment.getCourseName());
        dto.setName(enrollment.getName());
        dto.setEmail(enrollment.getEmail());
        dto.setPhone(enrollment.getPhone());
        dto.setMode(enrollment.getMode());
        dto.setMessage(enrollment.getMessage());
        dto.setCreatedDate(enrollment.getCreatedDate());
        return dto;
    }
}

