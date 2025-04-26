package com.krutrim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.krutrim.entity.Enquiry;

public interface EnquiryRepository extends MongoRepository<Enquiry, String> {

}
