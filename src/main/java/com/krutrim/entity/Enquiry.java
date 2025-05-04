package com.krutrim.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "enquiries")
public class Enquiry {

    @Id
    private String id;
    private String name;
    private String email;
    private String mobile;
    private String message;
    @CreatedDate
    private LocalDateTime createdDate;
}

