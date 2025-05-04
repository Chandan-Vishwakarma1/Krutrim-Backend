package com.krutrim.service;

import java.util.List;

import com.krutrim.dto.EnquiryRequestDto;
import com.krutrim.dto.EnquiryResponseDto;
import com.krutrim.mapper.EnquiryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krutrim.entity.Enquiry;
import com.krutrim.repository.EnquiryRepository;

@Service
public class EnquiryService {

    @Autowired
    private EnquiryRepository enquiryRepository;

    public EnquiryResponseDto createEnquiry(EnquiryRequestDto enquiryRequestDto) {
        Enquiry enquiry = EnquiryMapper.toEntity(enquiryRequestDto);
        return EnquiryMapper.toDto(enquiryRepository.save(enquiry));
    }

    public List<EnquiryResponseDto> getAllEnquiries() {
        return EnquiryMapper.toDtoList(enquiryRepository.findAll());
    }

    public void deleteAllEnrollments() {
        enquiryRepository.deleteAll();
    }

}

