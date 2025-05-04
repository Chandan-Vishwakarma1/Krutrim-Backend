package com.krutrim.mapper;

import com.krutrim.dto.EnquiryRequestDto;
import com.krutrim.dto.EnquiryResponseDto;
import com.krutrim.entity.Enquiry;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

public class EnquiryMapper {

    public static Enquiry toEntity(EnquiryRequestDto dto) {
        Enquiry enquiry = new Enquiry();
        enquiry.setName(dto.getName());
        enquiry.setEmail(dto.getEmail());
        enquiry.setMobile(dto.getMobile());
        return enquiry;
    }

    public static EnquiryResponseDto toDto(Enquiry enquiry) {
        EnquiryResponseDto dto = new EnquiryResponseDto();
        dto.setId(enquiry.getId());
        dto.setName(enquiry.getName());
        dto.setEmail(enquiry.getEmail());
        dto.setMobile(enquiry.getMobile());
        return dto;
    }

    public static List<EnquiryResponseDto> toDtoList(List<Enquiry> enquiries) {
        return enquiries.stream()
                .map(EnquiryMapper::toDto)
                .collect(Collectors.toList());
    }
}