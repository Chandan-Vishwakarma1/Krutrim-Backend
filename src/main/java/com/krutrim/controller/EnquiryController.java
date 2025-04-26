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
import com.krutrim.entity.Enquiry;
import com.krutrim.service.EnquiryService;

@CrossOrigin(origins = "https://your-app.vercel.app")
@RestController
@RequestMapping("/enquiries")
public class EnquiryController {

    @Autowired
    private EnquiryService enquiryService;

    @PostMapping
    public ResponseEntity<ApiResponseDto<Enquiry>> createEnquiry(@RequestBody Enquiry enquiry) {
        Enquiry createdEnquiry = enquiryService.createEnquiry(enquiry);
        ApiResponseDto<Enquiry> response = new ApiResponseDto<>(true, "Enquiry success", createdEnquiry);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @GetMapping
    public ResponseEntity<ApiResponseDto<List<Enquiry>>> getAllEnquiries() {
        List<Enquiry> enquiries = enquiryService.getAllEnquiries();
        ApiResponseDto<List<Enquiry>> response = new ApiResponseDto<>(true, "Enquiries fetched successfully", enquiries);
        return ResponseEntity.ok(response);
    }

}

