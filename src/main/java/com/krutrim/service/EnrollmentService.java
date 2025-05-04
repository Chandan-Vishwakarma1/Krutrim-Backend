package com.krutrim.service;

import java.util.List;
import java.util.stream.Collectors;

import com.krutrim.dto.EnrollmentRequestDto;
import com.krutrim.dto.EnrollmentResponseDto;
import com.krutrim.exception.EmailAlreadyExistsException;
import com.krutrim.exception.PhoneAlreadyExistsException;
import com.krutrim.mapper.EnrollmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krutrim.entity.Enrollment;
import com.krutrim.repository.EnrollmentRepository;

@AllArgsConstructor
@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private EmailService emailService;

    public EnrollmentResponseDto createEnrollment(EnrollmentRequestDto enrollmentRequestDto) {

        if (enrollmentRepository.existsByEmail(enrollmentRequestDto.getEmail())) {
            throw new EmailAlreadyExistsException("Email already registered");
        }
        if (enrollmentRepository.existsByPhone(enrollmentRequestDto.getPhone())) {
            throw new PhoneAlreadyExistsException("Phone number already registered");
        }
        Enrollment enrollment = EnrollmentMapper.toEntity(enrollmentRequestDto);
        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        if (enrollment.getEmail() != null) {
            emailService.sendEnrollmentEmail(enrollment.getEmail(), enrollment.getName());
        }
        return EnrollmentMapper.toDto(savedEnrollment);
    }

    public List<EnrollmentResponseDto> getAllEnrollments() {
        List<Enrollment> all = enrollmentRepository.findAll();
        return all.stream()
                .map(EnrollmentMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteAllEnrollments() {
        enrollmentRepository.deleteAll();
    }

}

