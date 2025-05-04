package com.krutrim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.krutrim.entity.Enrollment;

public interface EnrollmentRepository extends MongoRepository<Enrollment, String> {
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}
