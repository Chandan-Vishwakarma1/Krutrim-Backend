package com.krutrim.controller;


import java.util.List;

import com.krutrim.dto.EnrollmentRequestDto;
import com.krutrim.dto.EnrollmentResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.krutrim.dto.ApiResponseDto;
import com.krutrim.entity.Enrollment;
import com.krutrim.service.EnrollmentService;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<ApiResponseDto<EnrollmentResponseDto>> createEnrollment(@Valid @RequestBody EnrollmentRequestDto enrollmentRequestDto) {
    	EnrollmentResponseDto createdEnrollment = enrollmentService.createEnrollment(enrollmentRequestDto);
    	ApiResponseDto<EnrollmentResponseDto> response = new ApiResponseDto<>(HttpStatus.CREATED.value(), "Enrollment success", createdEnrollment);
    	return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<EnrollmentResponseDto>>> getAllEnrollments() {
    	 List<EnrollmentResponseDto> enrollments = enrollmentService.getAllEnrollments();
    	    ApiResponseDto<List<EnrollmentResponseDto>> response = new ApiResponseDto<>(HttpStatus.OK.value(), "All enrollments retrieved successfully", enrollments);
    	    return ResponseEntity.ok(response);
    }


    @DeleteMapping
    public ResponseEntity<String> deleteAllEnrollments() {
        enrollmentService.deleteAllEnrollments();
        return ResponseEntity.ok("All enrollments deleted successfully");
    }

}

