package com.krutrim.controller;

import java.util.List;

import com.krutrim.dto.EnquiryRequestDto;
import com.krutrim.dto.EnquiryResponseDto;
import com.krutrim.dto.EnrollmentResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.krutrim.dto.ApiResponseDto;
import com.krutrim.entity.Enquiry;
import com.krutrim.service.EnquiryService;

@RestController
@RequestMapping("/enquiries")
public class EnquiryController {

    @Autowired
    private EnquiryService enquiryService;

    @PostMapping
    public ResponseEntity<ApiResponseDto<EnquiryResponseDto>> createEnquiry(@Valid @RequestBody EnquiryRequestDto enquiryRequestDto) {
        EnquiryResponseDto createdEnquiry = enquiryService.createEnquiry(enquiryRequestDto);
        ApiResponseDto<EnquiryResponseDto> response = new ApiResponseDto<>(HttpStatus.CREATED.value(), "Enquiry success", createdEnquiry);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @GetMapping
    public ResponseEntity<ApiResponseDto<List<EnquiryResponseDto>>> getAllEnquiries() {
        List<EnquiryResponseDto> enquiries = enquiryService.getAllEnquiries();
        ApiResponseDto<List<EnquiryResponseDto>> response = new ApiResponseDto<>(HttpStatus.OK.value(), "Enquiries fetched successfully", enquiries);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

//    @DeleteMapping
//    public ResponseEntity<ApiResponseDto<Void>> deleteAllEnquiries() {
//        enquiryService.deleteAllEnrollments();
//        return ResponseEntity.ok(new ApiResponseDto<>(HttpStatus.OK.value(),"All enquiries deleted successfully",null));
//    }


}

