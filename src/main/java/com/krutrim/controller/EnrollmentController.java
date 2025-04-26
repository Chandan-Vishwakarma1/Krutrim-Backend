package com.krutrim.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krutrim.dto.ApiResponseDto;
import com.krutrim.entity.Enrollment;
import com.krutrim.service.EnrollmentService;

@CrossOrigin(origins = "https://your-app.vercel.app")
@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<ApiResponseDto<Enrollment>> createEnrollment(@RequestBody Enrollment enrollment) {
    	Enrollment createdEnrollment = enrollmentService.createEnrollment(enrollment);
    	ApiResponseDto<Enrollment> response = new ApiResponseDto<>(true, "Enrollment success", createdEnrollment);
    	return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<Enrollment>>> getAllEnrollments() {
    	 List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
    	    ApiResponseDto<List<Enrollment>> response = new ApiResponseDto(true, "All enrollments retrieved successfully", enrollments);
    	    return ResponseEntity.ok(response);
    }
}

